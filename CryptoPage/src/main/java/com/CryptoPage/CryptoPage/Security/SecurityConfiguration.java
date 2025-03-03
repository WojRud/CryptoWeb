package com.CryptoPage.CryptoPage.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/register", "/login", "/", "/css/**", "/js/**").permitAll()
                        .anyRequest().authenticated()
                )

                .csrf(csrf -> csrf.disable())

                .formLogin(form -> form
                        .loginPage("/login")
      //                  .defaultSuccessUrl("/welcome", true)
                        .permitAll()
                );
      /*          .logout(logout -> logout
                        .permitAll()

                );
      */
        return http.build();
    }
}