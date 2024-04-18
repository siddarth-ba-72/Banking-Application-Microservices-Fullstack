package com.finance.banking.ApiGatewayService.Utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtUtil {

    public static final String JWT_SECRET = "88ywcertyquwddnc2487239cb76yhj9876t8revbchfgvbw8g73rhfbvercgrebviyeworyvcbure87r783";

    public void validateToken(final String token) {
        Jwts.parserBuilder().setSigningKey(JWT_SECRET.getBytes()).build().parseClaimsJws(token);
    }

    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}