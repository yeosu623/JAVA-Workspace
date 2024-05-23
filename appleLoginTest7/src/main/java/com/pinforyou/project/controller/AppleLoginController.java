package com.pinforyou.project.controller;

import com.pinforyou.project.apple.AppleJwtUtils;
import com.pinforyou.project.apple.AppleLoginRequest;
import com.pinforyou.project.apple.AppleLoginResponse;
import com.pinforyou.project.apple.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Claims;

@RestController
@RequestMapping("/api/v1/apple")
public class AppleLoginController {

    private final AppleJwtUtils appleJwtUtils;

    public AppleLoginController(AppleJwtUtils appleJwtUtils) {
        this.appleJwtUtils = appleJwtUtils;
    }

    @PostMapping("/login") // POST 요청으로 '/login' 경로로 들어오는 요청을 처리
    public ResponseEntity<AppleLoginResponse> handleLogin(@RequestBody AppleLoginRequest request) {
        System.out.println("Received login request with identityToken: " + request.getIdentityToken());
        try {
            // 전달받은 identityToken을 검증하여 클레임을 추출
            Claims claims = appleJwtUtils.getClaimsBy(request.getIdentityToken());

            // 클레임에서 사용자 정보 추출 (예: subject는 사용자의 고유 ID)
            String userId = claims.getSubject();

            System.out.println("Extracted userId: " + userId);

            // 여기서 사용자 정보를 데이터베이스에서 조회하거나 새로 등록하는 등의 로직을 수행

            // 응답으로 사용자 정보를 반환 (예시로 userId 반환)
            return ResponseEntity.ok(new AppleLoginResponse(userId));
        } catch (Exception e) {
            // 예외 발생 시 에러 메시지와 함께 401 Unauthorized 응답
            return ResponseEntity.status(401).body(new AppleLoginResponse("Invalid token or authentication failed."));
        }
    }
}