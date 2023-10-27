package com.gotcha.main.service.impl;

import com.gotcha.main.service.KeycloakService;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.AccessTokenResponse;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class KeycloakServiceImpl implements KeycloakService {

    private final Keycloak keycloak;

    public KeycloakServiceImpl(Keycloak keycloak) {
        this.keycloak = keycloak;
    }

    @Override
    public void create() {


        CredentialRepresentation credentials = new CredentialRepresentation();
        credentials.setTemporary(false);
        credentials.setType(CredentialRepresentation.PASSWORD);
        credentials.setValue("Abc1");
        UserRepresentation user = new UserRepresentation();
        user.setUsername("Ower2");
        user.setFirstName("omer");
        user.setLastName("erden");
        user.setEmail("ower@cydeo.com");
        user.setCredentials(Collections.singletonList(credentials));
        user.setEmailVerified(true);
        user.setEnabled(true);
        user.setRealmRoles(Collections.singletonList("ADMIN"));

//        AccessTokenResponse token = keycloak.tokenManager().getAccessToken();
//        System.out.println(token);

        var x = keycloak.realm("External").users().create(user);


    }
}
