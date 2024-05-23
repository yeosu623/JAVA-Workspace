package com.pinforyou.project.apple;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(name = "appleClient", url = "https://appleid.apple.com/auth", configuration = AppleFeignConfig.class)
public interface AppleClient {

    // authorization code 받아옴
    @GetMapping(value = "/keys")
    ApplePublicKeyResponse getAppleAuthPublicKey();

    // authorization code로 token 생성
    @PostMapping(value = "/token", consumes = "application/x-www-form-urlencoded")
    AppleToken.Response getToken(AppleToken.Request request);

    
    // 수정해야함
    // 만료된 access token을 위해 accessmgl;wlk'l
    @PostMapping(value = "/refresh-token", consumes = "application/x-www-form-urlencoded")
    AppleAccessToken.Response refreshToken(AppleAccessToken.Request request);
}