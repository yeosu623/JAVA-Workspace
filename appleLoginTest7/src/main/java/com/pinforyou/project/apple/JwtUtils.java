package com.pinforyou.project.apple;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.IOException;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public abstract class JwtUtils {

    // application.properties
    @Value("${apple.team-id")
    private String teamId;

    @Value("${apple.key-id")
    private String keyId;

    @Value("${apple.client-id")
    private String clientId;

    @Value("${apple.key-path")
    private String privateKey;

    protected String getClientId() {
        return clientId;
    }

    public String makeClientSecret() throws IOException, java.io.IOException {
        Date expirationDate = Date.from(LocalDateTime.now().plusDays(30).atZone(ZoneId.systemDefault()).toInstant());
        return Jwts.builder()
                .setHeaderParam("kid", keyId)
                .setHeaderParam("alg", "ES256")
                .setIssuer(teamId)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(expirationDate)
                .setAudience("https://appleid.apple.com")
                .setSubject(clientId)
                .signWith(SignatureAlgorithm.ES256, getPrivateKey())
                .compact();
    }

    private PrivateKey getPrivateKey() throws IOException, java.io.IOException {
        ClassPathResource resource = new ClassPathResource("key/AuthKey_MM5WUVJM5S.p8");
        String privateKey = new String(Files.readAllBytes(Paths.get(resource.getURI())));
        Reader pemReader = new StringReader(privateKey);
        PEMParser pemParser = new PEMParser(pemReader);
        JcaPEMKeyConverter converter = new JcaPEMKeyConverter();
        PrivateKeyInfo object = (PrivateKeyInfo) pemParser.readObject();
        return converter.getPrivateKey(object);
    }

    public abstract Claims getClaimsBy(String identityToken);
}