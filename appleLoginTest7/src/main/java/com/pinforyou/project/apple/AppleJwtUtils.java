package com.pinforyou.project.apple;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.Base64;
import java.util.Map;

import static org.hibernate.query.sqm.tree.SqmNode.log;

@Slf4j
@Component
@RequiredArgsConstructor
public class AppleJwtUtils extends JwtUtils{

    private final AppleClient appleClient;

    private final ObjectMapper objectMapper;

    /*public void printTokenTest() {
        AppleToken.Request request = AppleToken.Request.of("authorization_code", "client_id", "client_secret", "authorization_code", "refresh_token");

        log.info("Sending request to Apple: {}", request);

        try {
            AppleToken.Response response = appleClient.getToken(request);
            log.info("Received response from Apple: {}", response);
        } catch (Exception e) {
            log.error("Error occurred while getting token from Apple", e);
        }
    }*/

    @Override
    public Claims getClaimsBy(String identityToken){
        try {
            ApplePublicKeyResponse response = appleClient.getAppleAuthPublicKey();

            String identityTokenHeader = identityToken.substring(0, identityToken.indexOf("."));

            //identityTokenHeader decode
            String decodedIdentityTokenHeader = new String(Base64.getDecoder().decode(identityTokenHeader), StandardCharsets.UTF_8);

            Map<String, String> header = objectMapper.readValue(decodedIdentityTokenHeader, Map.class);
            ApplePublicKeyResponse.Key key = response.getMatchedKeyBy(header.get("kid"), header.get("alg"))
                    .orElseThrow(() -> new NullPointerException("Failed get public key from apple's id server."));

            // public key 생성
            byte[] nBytes = Base64.getUrlDecoder().decode(key.getN());
            byte[] eBytes = Base64.getUrlDecoder().decode(key.getE());

            BigInteger n = new BigInteger(1, nBytes);
            BigInteger e = new BigInteger(1, eBytes);

            RSAPublicKeySpec publicKeySpec = new RSAPublicKeySpec(n, e);
            KeyFactory keyFactory = KeyFactory.getInstance(key.getKty());
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);


            // jwt 검증 및 클레임 추출
            return Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(identityToken)
                    .getBody();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            // 키 생성 관련 예외 처리
            e.printStackTrace();
            throw new RuntimeException("Invalid key specification.", e);
        } catch (MalformedJwtException e) {
            // 토큰 서명 검증 실패 또는 구조적 문제 (Invalid token)
            e.printStackTrace();
            throw new RuntimeException("Invalid token.", e);
        } catch (ExpiredJwtException e) {
            // 토큰이 만료됨
            e.printStackTrace();
            throw new RuntimeException("Token expired.", e);
        } catch (Exception e) {
            // 기타 예외 처리
            e.printStackTrace();
            throw new RuntimeException("Token validation failed.", e);
        }
    }


    // Feign Client를 사용해 Apple 서버에 요청하고 응답 결과를 출력하는 메서드
    /*public void printToken() {
        try {
            AppleToken.Request request = AppleToken.Request.of(
                    "authorization_code",
                    getClientId(),
                    makeClientSecret(),
                    "authorization_code",
                    "refresh_token"
            );

            AppleToken.Response response = appleClient.getToken(request);

            System.out.println("Access Token: " + response.getAccess_token());
            System.out.println("Token Type: " + response.getToken_type());
            System.out.println("Expires In: " + response.getExpires_in());
            System.out.println("Refresh Token: " + response.getRefresh_token());
            System.out.println("ID Token: " + response.getId_token());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}