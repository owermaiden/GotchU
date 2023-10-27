package com.gotcha.main.controller;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IndexController {

    @GetMapping(path = "/")
    public HashMap index() {
        // get a successful user login
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();

        return new HashMap(){{
            put("hello", loggedInUser.getName());
            put("your email is", loggedInUser.getPrincipal());
        }};
    }


    @GetMapping(path = "/unauthenticated")
    public HashMap unauthenticatedRequests() {
        return new HashMap(){{
            put("this is ", "unauthenticated endpoint");
        }};
    }
}

//{
//        "your email is": {
//        "tokenValue": "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJQeVpVN2pkejhtSmlWSWxrdHVzUHZsdGxmTVZjRUFValkwNnFjYTAwb0tBIn0.eyJleHAiOjE2OTg0Mjg1ODksImlhdCI6MTY5ODQyODI4OSwianRpIjoiODZiMmZiNWEtNDhlOC00YTFlLWFlODQtOTIxNTA1NDAzZTUzIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL3JlYWxtcy9FeHRlcm5hbCIsImF1ZCI6ImFjY291bnQiLCJzdWIiOiJjYTljZmJmMS05MDk5LTRjMWYtYjEzNy1hYzliMWI2NjMwNjEiLCJ0eXAiOiJCZWFyZXIiLCJhenAiOiJleHRlcm5hbC1jbGllbnQiLCJzZXNzaW9uX3N0YXRlIjoiZjc1ODk2MzktMTIwNC00M2Q0LThiYmUtODVkYTM0NTU0YjU0IiwiYWNyIjoiMSIsImFsbG93ZWQtb3JpZ2lucyI6WyIvKiJdLCJyZWFsbV9hY2Nlc3MiOnsicm9sZXMiOlsib2ZmbGluZV9hY2Nlc3MiLCJkZWZhdWx0LXJvbGVzLWV4dGVybmFsIiwiQURNSU4iLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGVtYWlsIHByb2ZpbGUiLCJzaWQiOiJmNzU4OTYzOS0xMjA0LTQzZDQtOGJiZS04NWRhMzQ1NTRiNTQiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoib3dlciJ9.SaRBZlGPsLLskzwmWgj8gkJxLKi6ld3dZixeHSFU2IOpMd_Avx_OhBKadNCqPFYthcyYBkaXr701jEzxfO_p-oXpqGv-INw4h0OK1_h-cXq2QXZMgrF4E0I1Hl1Ui5M_EBV2s_Rq3EGLFKEjeKiTE8QamFjfbB-_i5RfeN0ood3gEgw26LZhqin2h9HR9y8zngP8UrFSG48ibGFduCVQMzSZslgxGd-BErymMnuvczyJSfcoifIsIpNlHrRN58EatS2Cp2VgTCryG5N8Ro90XflvWQ4EUWaFC9Ls8NQZnm5A4nTopZWkwC_dge5Hj4tZnDI_ae5wYkpfPk385J5nVA",
//        "issuedAt": "2023-10-27T17:38:09Z",
//        "expiresAt": "2023-10-27T17:43:09Z",
//        "headers": {
//        "kid": "PyZU7jdz8mJiVIlktusPvltlfMVcEAUjY06qca00oKA",
//        "typ": "JWT",
//        "alg": "RS256"
//        },
//        "claims": {
//        "sub": "ca9cfbf1-9099-4c1f-b137-ac9b1b663061",
//        "resource_access": {
//        "account": {
//        "roles": [
//        "manage-account",
//        "manage-account-links",
//        "view-profile"
//        ]
//        }
//        },
//        "email_verified": true,
//        "allowed-origins": [
//        "/*"
//        ],
//        "iss": "http://localhost:8080/realms/External",
//        "typ": "Bearer",
//        "preferred_username": "ower",
//        "sid": "f7589639-1204-43d4-8bbe-85da34554b54",
//        "aud": [
//        "account"
//        ],
//        "acr": "1",
//        "realm_access": {
//        "roles": [
//        "offline_access",
//        "default-roles-external",
//        "ADMIN",
//        "uma_authorization"
//        ]
//        },
//        "azp": "external-client",
//        "scope": "openid email profile",
//        "exp": "2023-10-27T17:43:09Z",
//        "session_state": "f7589639-1204-43d4-8bbe-85da34554b54",
//        "iat": "2023-10-27T17:38:09Z",
//        "jti": "86b2fb5a-48e8-4a1e-ae84-921505403e53"
//        },
//        "subject": "ca9cfbf1-9099-4c1f-b137-ac9b1b663061",
//        "id": "86b2fb5a-48e8-4a1e-ae84-921505403e53",
//        "issuer": "http://localhost:8080/realms/External",
//        "audience": [
//        "account"
//        ],
//        "notBefore": null
//        },
//        "hello": "ca9cfbf1-9099-4c1f-b137-ac9b1b663061"
//        }
