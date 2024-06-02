package com.example.TestTask.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Вимкнути CSRF для тестування
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/**").permitAll() // Дозволити доступ до всіх ендпоінтів під /api/
                        .anyRequest().permitAll() // Вимагати авторизацію для інших запитів
                );

        return http.build();
    }
}
