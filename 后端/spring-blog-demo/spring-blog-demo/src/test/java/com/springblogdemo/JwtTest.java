package com.springblogdemo;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    void getToken() {
        Key key = Keys.hmacShaKeyFor("wKbpU1B7OOrJVb98aglQ/R8HGin80OWD5LpMO+o+69c=".getBytes(StandardCharsets.UTF_8));
//        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "zhangsan");

        // 生成token
        String compact = Jwts.builder()
                .setClaims(claims)
                .signWith(key)
                .compact();
        System.out.println(compact);

        // 校验token
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        System.out.println(build.parse(compact).getBody());
    }

    @Test
    void genKey() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String encode = Encoders.BASE64.encode(key.getEncoded());
        System.out.println(encode);
    }
}
