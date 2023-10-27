package com.gotcha.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collection;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity
//                .authorizeHttpRequests(registry -> registry
//                        .requestMatchers("/users", "/oauth2/**", "/login/**").hasRole("ADMIN")
//                        .requestMatchers("/**").hasRole("SYS_ADMIN")
//                        .anyRequest().authenticated()
//                )
//                .oauth2ResourceServer(oauth2Configurer -> oauth2Configurer.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwt -> {
//                    Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
//                    Collection<String> roles = realmAccess.get("roles");
//                    var grantedAuthorities = roles.stream()
//                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//                            .toList();
//                    return new JwtAuthenticationToken(jwt, grantedAuthorities);
//                })))
//        ;
//
//        return httpSecurity.build();
        return httpSecurity.cors(Customizer.withDefaults())
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(httpRequests -> httpRequests
                        .requestMatchers("/users", "/oauth2/**", "/login/**").hasRole("ADMIN")
                        .anyRequest().authenticated())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(oauth2ResourceServer -> oauth2ResourceServer.jwt(jwtConfigurer -> jwtConfigurer.jwtAuthenticationConverter(jwt -> {
                    Map<String, Collection<String>> realmAccess = jwt.getClaim("realm_access");
                    Collection<String> roles = realmAccess.get("roles");
                    var grantedAuthorities = roles.stream()
                            .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                            .toList();
                    return new JwtAuthenticationToken(jwt, grantedAuthorities);
                })))
                .build();
    }

}
