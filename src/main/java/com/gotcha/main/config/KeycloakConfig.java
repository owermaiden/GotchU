package com.gotcha.main.config;

import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientBuilderImpl;
import org.jboss.resteasy.client.jaxrs.internal.ResteasyClientImpl;
import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    @Bean
    Keycloak keycloakadmin(){

        return KeycloakBuilder.builder()
                .serverUrl("http://localhost:8080")
                .grantType(OAuth2Constants.PASSWORD)
                .realm("master")
                .username("admin")
                .password("admin")
                .clientId("admin-cli")
                .resteasyClient(new ResteasyClientBuilderImpl().connectionPoolSize(10).build())
                .build();
    }
}
