package com.kane.account.controller;


import com.kane.account.infra.client.AuthClient;
import com.kane.common.dto.request.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AuthClient authClient;

    @PostMapping
    ResponseEntity<?> test () {
        SignUpRequest request = new SignUpRequest();
        request.setName("Test");
        request.setUsername("testuser");
        request.setPassword("123456");
        var res = authClient.auth(request);
        return ResponseEntity.ok(res.getBody());
    }
}
