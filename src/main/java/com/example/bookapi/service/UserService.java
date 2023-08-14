package com.example.bookapi.service;

import com.example.bookapi.dto.UserDto;
import com.example.bookapi.dto.UserRequest;
import com.example.bookapi.exception.EntityAlreadyExistException;
import com.example.bookapi.model.User;
import com.example.bookapi.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
/*
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity<UserDto> add(UserRequest userRequest){
        userRepository.findByName(userRequest.getNickName()).ifPresent(
                l ->{throw new EntityAlreadyExistException("User already exist this nickName"); });

        UserDto userDto = new UserDto();

        userDto.setName(userRequest.getName());
        userDto.setSurname(userRequest.getSurname());
        userDto.setNickName(userRequest.getNickName());
        userDto.setEmail(userRequest.getEmail());
        userDto.setPassword(userRequest.getPassword());


        
    }

    public ResponseEntity<UserDto> getAll() {
    }
    

    public ResponseEntity<UserDto> updateSurname(UserRequest userRequest, String name) {
    }

    public void deleteById(String id) {
    }

    public ResponseEntity<UserDto> getByName(String name) {
    }

    public ResponseEntity<UserDto> getById(String id) {
    }
}
*/