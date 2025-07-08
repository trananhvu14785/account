package com.kane.account.infra.client;

import com.kane.common.dto.request.SignInRequest;
import com.kane.common.dto.request.SignUpRequest;
import com.kane.common.dto.response.SignInResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "auth-service", url = "${auth-service.url}")
public interface AuthClient {

  //    @PostMapping("/auth")
  //    ResponseEntity<String> auth();

  @PostMapping("/auth/signIn")
  SignInResponse signIn(SignInRequest request);

  @PostMapping("/login")
  ResponseEntity<SignInResponse> login(@RequestBody SignUpRequest signUpRequest);

  @GetMapping("/auth/hello")
  String hello();
}
