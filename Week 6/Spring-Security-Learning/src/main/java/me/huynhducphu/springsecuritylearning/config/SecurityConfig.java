package me.huynhducphu.springsecuritylearning.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Admin 10/27/2025
 **/
@Configuration
public class SecurityConfig {

    // Neu khong khai bao passwordEncoder, Spring lay default
    // Neu khai bao thi no uu tien lay cai cua ban
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Trong spring lop User se la UserDetails
    // Lop xu ly user thi se la UserDetailsService
    // con lop User la 1 cai builder
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails member = User
                .builder()
                .username("khanh-wibu")
                .password(passwordEncoder().encode("123"))
                .roles("MEMBER")
                .build();

        UserDetails admin = User
                .builder()
                .username("HDP")
                .password(passwordEncoder().encode("123"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(member, admin);
    }

    @Bean
    // Spring se tu dong tiem/inject dependecy vao method
    // HttpSecurity la 1 class builder (class cấu hình)
    // CO' THE TAM HIEU BAY GIO LA LOP  UTILS
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/home").hasAnyRole("MEMBER", "ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/home")
                )
                .logout(logout -> logout
                        .logoutSuccessUrl("/login")
                )
                .build();

    }


}
