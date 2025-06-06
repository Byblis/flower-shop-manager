package com.example.flowershopmanager.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**").permitAll() // ログイン画面やCSSは誰でもOK
                .anyRequest().authenticated()                    // 他はログイン必須
            )
            .formLogin(form -> form
                // .loginPage("/login") ← カスタムログイン画面使いたいなら有効に！
                .defaultSuccessUrl("/dashboard", true)           // ログイン後ダッシュボードへ
                .permitAll()
            )
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")               // ログアウト後にログイン画面
                .permitAll()
            );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("user")
            .password("{noop}12345") // {noop}でハッシュ化なしパスOK！
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }
}

