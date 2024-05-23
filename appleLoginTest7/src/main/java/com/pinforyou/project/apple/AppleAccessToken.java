package com.pinforyou.project.apple;

import lombok.Setter;

public class AppleAccessToken {

    @Setter
    public static class Request {
        // private String code;
        private String client_id;
        private String client_secret;
        private String grant_type;
        private String refresh_token;

        public static AppleAccessToken.Request of(String clientId, String clientSecret, String grantType, String refreshToken) {
            AppleAccessToken.Request request = new AppleAccessToken.Request();
            // request.code = code;
            request.client_id = clientId;
            request.client_secret = clientSecret;
            request.grant_type = grantType;
            request.refresh_token = refreshToken;
            return request;
        }
    }

    @Setter
    public static class Response {
        private String access_token;
        private String expires_in;
        private String token_type;
        private String error;

        public String getAccessToken() {
            return access_token;
        }

        public String getExpiresIn() {
            return expires_in;
        }

        public String getTokenType() {
            return token_type;
        }
    }
}