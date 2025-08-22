package com.example.chatApp.configurations;

import com.example.chatApp.exceptions.UserNotFoundException;
import com.example.chatApp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
        private final UserRepository userRepository;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
                httpSecurity
                                .formLogin(form -> form
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/friends", true)
                                                .failureUrl("/login?error")
                                                .permitAll())
                                .logout(
                                                logout -> logout
                                                                .logoutUrl("/logout")// url user goi de logout
                                                                .logoutSuccessUrl("/login?logout")// trang dieu huong
                                                                                                  // sau khi logout
                                                                .permitAll())
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests(
                                                http -> http.requestMatchers(
                                                                "/login", "/register", "/css/**", "/js/**").permitAll()
                                                                .anyRequest().authenticated());
                return httpSecurity.build();
        }

        @Bean // authentication
        public UserDetailsService userDetailsService() {
                return userName -> userRepository
                                .findByUsername(userName)
                                .orElseThrow(() -> new UserNotFoundException(
                                                "Cannot find user with username = " + userName));
        }

        @Bean
        public PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }
}
