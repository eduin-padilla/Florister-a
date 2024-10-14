package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SuppressWarnings("unused")
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests()
                .requestMatchers("/login").permitAll() // Permitir acceso a la página de login
                .anyRequest().authenticated() // Requerir autenticación para cualquier otra ruta
                .and()
            .formLogin()
                .loginPage("/login") // Página de login personalizada
                .defaultSuccessUrl("/flores", true) // Redirección tras el login
                .permitAll() // Permitir acceso a la página de login
                .and()
            .logout()
                .logoutSuccessUrl("/login?logout") // Redirección tras el logout
                .permitAll(); // Permitir logout

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Usar BCrypt para codificar contraseñas
    }

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        UserDetails user = User.withUsername("user")
            .password(passwordEncoder().encode("contraseña")) 
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}
