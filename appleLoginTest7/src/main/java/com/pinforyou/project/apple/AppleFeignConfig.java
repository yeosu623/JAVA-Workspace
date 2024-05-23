package com.pinforyou.project.apple;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppleFeignConfig {
    // 외부 서비스와의 통신 중 발생한 오류를 ObjectMapper를 사용하여 디코딩하고 처리
    @Bean
    public ErrorDecoder errorDecoder(ObjectMapper objectMapper) {
        return new AppleFeignClientErrorDecoder(objectMapper);
    }
}

// Feign 클라이언트의 오류 처리를 위한 설정