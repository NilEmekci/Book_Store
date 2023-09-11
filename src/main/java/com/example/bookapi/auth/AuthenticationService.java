package com.example.bookapi.auth;


import com.example.bookapi.exception.EntityAlreadyExistException;
import com.example.bookapi.exception.EntityNotFoundException;
import com.example.bookapi.exception.EntityNotNullException;
import com.example.bookapi.user.Role;
import com.example.bookapi.token.Token;
import com.example.bookapi.token.TokenType;
import com.example.bookapi.user.User;
import com.example.bookapi.token.TokenRepository;
import com.example.bookapi.user.UserRepository;
import com.example.bookapi.config.JwtService;
import com.example.bookapi.writer.Writer;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {

        if (request.getFirstname() == null || request.getLastname() == null || request.getFirstname().isBlank() ||request.getLastname().isBlank()) {
            throw new EntityNotNullException("Name or surname cannot be null or blank");
        }
        if(request.getEmail() == null ||request.getEmail().isBlank() ){
            throw new EntityNotNullException("email cannot be null or blank");
        }
        if(isUserExist(request.getFirstname(), request.getLastname(), request.getEmail())){
            throw new EntityAlreadyExistException("User already exist ");
        }
        var user= User.builder()
                .name(request.getFirstname())
                .surname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(request.getRole())
                .build();
        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        saveUserToken(savedUser,jwtToken);

        return  AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        ));
        var user =userRepository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user,jwtToken);
        return  AuthenticationResponse.builder().accessToken(jwtToken).refreshToken(refreshToken).build();
    }
    private void revokeAllUserTokens(User user) {
        var validUserTokens = tokenRepository.findAllValidTokensByUser(user.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }

    private void saveUserToken(User user, String jwtToken){
        var token = Token.builder()
                .user(user)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .revoked(false)
                .expired(false)
                .build();
        tokenRepository.save(token);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {

        final String authHeader= request.getHeader(HttpHeaders.AUTHORIZATION);
        final String refreshToken;
        final String userEmail;
        if(authHeader==null|| !authHeader.startsWith("Bearer ")){
            return;
        }
        refreshToken= authHeader.substring(7);
        userEmail= jwtService.extractUsername(refreshToken);
        if(userEmail != null ){
            var userDetails =this.userRepository.findByEmail(userEmail).orElseThrow(()->new EntityNotFoundException("E-mail does not exist"));

            if(jwtService.isTokenValid(refreshToken,userDetails)){
               var accessToken  = jwtService.generateToken(userDetails);
                revokeAllUserTokens(userDetails);
                saveUserToken(userDetails,accessToken);
               var authResponse = AuthenticationResponse.builder()
                       .accessToken(accessToken)
                       .refreshToken(refreshToken)
                       .build();
               new ObjectMapper().writeValue(response.getOutputStream(),authResponse);
            }
        }
    }

    private boolean isUserExist(String firstName ,String lastName, String email){

        if(userRepository.findByName(firstName).isPresent() ){
            User user = userRepository.findByName(firstName).get();
            boolean checkSurname = user.getSurname().equals(lastName);
            if(checkSurname){
                return user.getEmail().equals(email);
            }
            return false;
        }
        return false;
    }


}
