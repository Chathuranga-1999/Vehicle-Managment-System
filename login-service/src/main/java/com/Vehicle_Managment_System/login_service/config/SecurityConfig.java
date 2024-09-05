package com.Vehicle_Managment_System.login_service.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configuring security rules
        http
                .csrf().disable() // Disabling CSRF protection for simplicity; enable it in production
                .authorizeHttpRequests()
                .requestMatchers("/auth/login", "/auth/register", "/auth/forgot-password").permitAll() // Allowing public access to login, registration, and forgot password endpoints
                .anyRequest().authenticated() // All other requests need authentication
                .and()
                .formLogin()
                .loginPage("/login") // Setting custom login page
                .defaultSuccessUrl("/dashboard", true) // Redirecting to dashboard on successful login
                .and()
                .logout()
                .logoutSuccessUrl("/login") // Redirecting to login page after logout
                .permitAll();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Using BCryptPasswordEncoder for password hashing
    }
}
