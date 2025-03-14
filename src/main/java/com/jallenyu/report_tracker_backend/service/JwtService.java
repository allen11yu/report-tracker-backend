package com.jallenyu.report_tracker_backend.service;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtService {
    private final Key key;

    public JwtService(@Value("${jwt.secret}") String secretKey) {
        this.key = Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    public String generateToken(String username, boolean rememberMe) {
        long expirationTime = 1000 * 60 * 60 * 24; // 1 Day

        JwtBuilder builder = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .signWith(key, SignatureAlgorithm.HS256);

        if (!rememberMe) {
            builder.setExpiration(new Date(System.currentTimeMillis() + expirationTime));
        }

        return builder.compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder().setSigningKey(key).build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        try {
            Claims claims = Jwts.parserBuilder().setSigningKey(key).build()
                    .parseClaimsJws(token)
                    .getBody();

            return extractUsername(token).equals(userDetails.getUsername()) && !isTokenExpired(claims);
        } catch (ExpiredJwtException e) {
            return false; // Token has expired
        }
    }

    private boolean isTokenExpired(Claims claims) {
        return claims.getExpiration() != null && claims.getExpiration().before(new Date());
    }
}
