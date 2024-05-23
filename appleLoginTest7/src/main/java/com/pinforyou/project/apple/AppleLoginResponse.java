package com.pinforyou.project.apple;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppleLoginResponse {

    private String userId;

    // 기본 생성자
    public AppleLoginResponse() {}

    // 매개변수를 받는 생성자
    public AppleLoginResponse(String userId) {
        this.userId = userId;
    }
}
