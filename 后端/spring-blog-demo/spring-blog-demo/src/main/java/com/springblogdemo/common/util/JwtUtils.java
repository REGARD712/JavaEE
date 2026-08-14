package com.springblogdemo.common.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Map;

public class JwtUtils {
    public static String SECRET_STRING = "wKbpU1B7OOrJVb98aglQ/R8HGin80OWD5LpMO+o+69c=";
    public static Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET_STRING));
    //或者：public static Key key = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));

    public static String genToken (Map<String, Object> claims) {
        String compact = Jwts.builder()
                .setClaims(claims)
                .signWith(key)
                .compact();
        return compact;
    }

    public static Claims parseToken (String token) {
        JwtParser build = Jwts.parserBuilder().setSigningKey(key).build();
        Claims claims = build.parseClaimsJws(token).getBody();
        return claims;
    }
}