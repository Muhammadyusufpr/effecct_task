package com.company.effecct.util;


import com.company.effecct.dto.detail.JwtDTO;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtUtil {
    private static final int tokenLiveTime = 1000 * 3600 * 24; // 1-day
    private static final String secretKey = "effect-mobile-test-project";

    public static String encode(Long id) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey);
        jwtBuilder.claim("id", id);
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (tokenLiveTime)));
        jwtBuilder.setIssuer("effect");
        return jwtBuilder.compact();
    }

    public static String encode(JwtDTO dto) {
        JwtBuilder jwtBuilder = Jwts.builder();
        jwtBuilder.setIssuedAt(new Date());
        jwtBuilder.signWith(SignatureAlgorithm.HS512, secretKey);
        jwtBuilder.claim("id", dto.getId().toString());
        jwtBuilder.setExpiration(new Date(System.currentTimeMillis() + (tokenLiveTime)));
        jwtBuilder.setIssuer("effect");
        return jwtBuilder.compact();
    }

    public static JwtDTO decode(String token) {
        JwtParser jwtParser = Jwts.parser();
        jwtParser.setSigningKey(secretKey);
        Jws<Claims> jws = jwtParser.parseClaimsJws(token);
        Claims claims = jws.getBody();
        String id = (String) claims.get("id");
        return new JwtDTO(Long.parseLong(id));
    }

    public static Long decodeForEmailVerification(String token) {
        JwtParser jwtParser = Jwts.parser();
        jwtParser.setSigningKey(secretKey);
        Jws<Claims> jws = jwtParser.parseClaimsJws(token);
        Claims claims = jws.getBody();
        return (Long) claims.get("id");
    }
}
