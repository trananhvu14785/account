package com.kane.account.infra.client;

import com.kane.common.dto.request.SignUpRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "${auth-service.url}")
public interface AuthClient {

//    @PostMapping("/auth")
//    ResponseEntity<String> auth();

    @PostMapping("/auth")
    ResponseEntity<Boolean> auth(@RequestBody SignUpRequest signUpRequest);
}
