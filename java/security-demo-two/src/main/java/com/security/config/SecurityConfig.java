package com.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Order(100)
    @Bean(name = "filter00")
    public SecurityFilterChain mySecurityFilter00(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .requestMatchers(matcherConfig -> matcherConfig.mvcMatchers("/"))
                .authorizeHttpRequests(authConfig -> authConfig
                        .mvcMatchers(HttpMethod.GET, "/")
                        .permitAll())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Order(101)
    @Bean(name = "filter01")
    public SecurityFilterChain mySecurityFilter01(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .requestMatchers(matcherConfig -> matcherConfig.mvcMatchers("/user/**"))
                .authorizeHttpRequests(authConfig -> authConfig
                        .mvcMatchers(HttpMethod.GET, "/user/**")
                        .hasAnyRole("ADMIN", "USER"))
                .authenticationProvider(this.authenticationProvider())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Order(102)
    @Bean(name = "filter02")
    public SecurityFilterChain mySecurityFilter02(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .requestMatchers(matcherConfig -> matcherConfig.mvcMatchers("/admin/**"))
                .authorizeHttpRequests(authConfig -> authConfig
                        .mvcMatchers(HttpMethod.GET, "/admin/**")
                        .hasRole("ADMIN"))
                .authenticationProvider(this.authenticationProvider())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Order(103)
    @Bean(name = "filter03")
    public SecurityFilterChain mySecurityFilter03(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .requestMatchers(matcherConfig -> matcherConfig.anyRequest())
                .authorizeHttpRequests(authConfig -> authConfig
                        .anyRequest()
                        .authenticated())
                .authenticationProvider(this.authenticationProvider())
                .httpBasic(Customizer.withDefaults())
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        final String adminEncodedPassword = this.encoder().encode("password");
        UserDetails admin = User.builder()
                .username("admin")
                .password(adminEncodedPassword)
                .roles("ADMIN")
                .build();

        final String userEncodedPassword = this.encoder().encode("123");
        UserDetails user = User.builder()
                .username("rafael")
                .password(userEncodedPassword)
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        return new CustomAuthenticationProvider(this.userDetailsService(), this.encoder());
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

}
