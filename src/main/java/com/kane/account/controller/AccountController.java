package com.kane.account.controller;


import com.kane.account.infra.client.AuthClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    private final AuthClient authClient;

    public AccountController(AuthClient authClient) {
        this.authClient = authClient;
    }

    @PostMapping
    ResponseEntity<?> test () {
        var res = authClient.auth();
        return ResponseEntity.ok(res.getBody());
    }
}
