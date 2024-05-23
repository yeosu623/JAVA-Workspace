package com.pinforyou.project.apple;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppleLoginRequest {

    private String identityToken;

    // 기본 생성자
    public AppleLoginRequest() {}

    // 매개변수를 받는 생성자
    public AppleLoginRequest(String identityToken) {
        this.identityToken = identityToken;
    }
}