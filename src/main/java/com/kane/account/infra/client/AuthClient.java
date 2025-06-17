package com.kane.account.infra.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "auth-service", url = "${auth-service.url}")
public interface AuthClient {

    @PostMapping("/auth")
    ResponseEntity<String> auth();
}
