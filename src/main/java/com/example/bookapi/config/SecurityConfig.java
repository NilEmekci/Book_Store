package com.example.bookapi.config;

import com.example.bookapi.user.Role;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import static com.example.bookapi.user.Role.ADMIN;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;

/*
    private static final String[] PUBLIC_URLS = {
            "/api/v1/auth/authenticate",
            "/api/v1/auth/register",

    };
    private static final String[] ADMIN_URLS = {
            "/v1/writer/**",
            "/v1/book/**",
            "/v1/evaluation/**",
            "/v1/genre/**",
            "/v1/user/**"

    };
    private static final String[] USER_URLS = {
            "/v1/writer/getByName/{name}",
            "/v1/writer/getById/{id}",
            "/v1/writer/getAll",
            "/v1/book/getByISBN/{isbn}",
            "/v1/book/getByName/{name}",
            "/v1/book/getAll",
            "/v1/genre/getById/{id}",
            "/v1/genre/getByName/{name}",
            "/v1/genre/getAll",

    };*/


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/auth/**")
              /*  .requestMatchers(PUBLIC_URLS).permitAll()
                .requestMatchers(USER_URLS).hasAnyAuthority(Role.ADMIN.name(), Role.USER.name())
                .requestMatchers(ADMIN_URLS).hasAnyAuthority(Role.ADMIN.name())*/
                .permitAll()
                // .requestMatchers("/v1/evaluation/**").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                .logout()
                .logoutUrl("/api/v1/auth/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
                ;



         return http.build();


    }



}