package com.pinforyou.project.apple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AppleTokenPrinter {

    private final AppleClient appleClient;

    @Autowired
    public AppleTokenPrinter(AppleClient appleClient) {
        this.appleClient = appleClient;
    }

    /*public void printToken() {
        // Apple 서버로부터 토큰을 받아옴
        AppleToken.Request request = AppleToken.Request.of(
                "authorization_code",
                getClientId(),
                makeClientSecret(),
                "authorization_code",
                "refresh_token" // 리프레시 토큰 설정 필요
        );

        // Apple 서버로부터 토큰을 받아옴
        AppleToken.Response response = appleClient.getToken(request);

        // 받아온 토큰 정보를 출력
        System.out.println("Access Token: " + response.getAccess_token());
        System.out.println("Token Type: " + response.getToken_type());
        System.out.println("Expires In: " + response.getExpires_in());
        System.out.println("Refresh Token: " + response.getRefresh_token());
        System.out.println("ID Token: " + response.getId_token());
    }*/
}
