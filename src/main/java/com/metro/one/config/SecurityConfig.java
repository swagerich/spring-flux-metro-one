package com.metro.one.config;

import com.metro.one.security.SecurityContextRepo;
import com.metro.one.security.jwt.JwtFilter;
import com.metro.one.utils.endpoints.ApiVersion;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.SecurityWebFiltersOrder;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
public class SecurityConfig implements WebFluxConfigurer {

    private final SecurityContextRepo securityContextRepo;

    public SecurityConfig(SecurityContextRepo securityContextRepo) {
        this.securityContextRepo = securityContextRepo;
    }

    @Bean
    public SecurityWebFilterChain webFilterChain(ServerHttpSecurity http, JwtFilter jwtFilter) {
        return http.authorizeExchange(exchange -> exchange.pathMatchers(ApiVersion.V1 + "auth/**").permitAll()
                        .anyExchange().authenticated()).csrf(ServerHttpSecurity.CsrfSpec::disable)
                .addFilterAfter(jwtFilter, SecurityWebFiltersOrder.FIRST)
                .securityContextRepository(securityContextRepo)
                .formLogin(ServerHttpSecurity.FormLoginSpec::disable)
                .logout(ServerHttpSecurity.LogoutSpec::disable)
                .httpBasic(ServerHttpSecurity.HttpBasicSpec::disable).build();
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH")
                .allowedOriginPatterns("http://localhost:4200", "http://localhost:5480")
                .allowCredentials(true);
        WebFluxConfigurer.super.addCorsMappings(registry);
    }


    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
