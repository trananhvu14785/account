package com.kane.account.controller;

import com.kane.account.infra.client.AuthClient;
import com.kane.common.dto.request.SignInRequest;
import com.kane.common.dto.response.SignInResponse;
import com.kane.common.response.SuccessResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {

  private final AuthClient authClient;

  @PostMapping("/signIn")
  public SuccessResponse<SignInResponse> signIn(@RequestBody SignInRequest request) {
    try {
      SuccessResponse<SignInResponse> response = authClient.signIn(request);
      return response;
    } catch (Exception e) {
      throw new RuntimeException("Invalid username or password", e);
    }
  }

  @GetMapping("/call-auth")
  public ResponseEntity<String> callAuth() {
    String response = authClient.hello();
    return ResponseEntity.ok("Account gọi auth: " + response);
  }

  @GetMapping("/test")
  public ResponseEntity<String> test() {
    return ResponseEntity.ok("Account gọi auth: ");
  }
}
