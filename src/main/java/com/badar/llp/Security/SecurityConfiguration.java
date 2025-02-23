package com.badar.llp.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(customizer -> customizer.disable());  // This line is used to Disable CSRF Token and make it easier to login
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated()); // Added this so that any request that comes through is allowed and authenticated
        http.httpBasic(Customizer.withDefaults()); // Allows basic commands to be done on postman
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)); // This remove the session ID


        return http.build();
    }

}

