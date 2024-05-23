package com.pinforyou.project.apple;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pinforyou.project.common.MyServerException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
public class AppleFeignClientErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    /**
     * 애플 소셜 로그인 Feign API 연동 시 발생되는 오류에 대해서 예외 처리를 수행.
     *
     * @param methodKey Feign Client 메서드 이름
     * @param response  응답 정보
     * @return 예외를 리턴한다
     */

    // Feign 클라이언트에서 발생하는 오류를 처리하기 위한 decode 메서드를 오버라이드
    @Override
    public Exception decode(String methodKey, Response response) {
        Map<String, Object> body = null;
        if (response != null && response.body() != null) {
            try {
                body = objectMapper.readValue(response.body().asInputStream(), Map.class);
            } catch (IOException e) {
                log.error("Error decoding response body", e);
            }
        }

        log.error("애플 소셜 로그인 Feign API Feign Client 호출 중 오류가 발생되었습니다. body: {}", body);

        return new MyServerException(response.status(), "애플 소셜 로그인 Feign API Feign Client 호출 오류");
    }
}

// Feign 클라이언트에서 발생하는 오류를 처리하기 위한 사용자 정의 오류 디코더 -> 오류를 적절한 예외로 처리