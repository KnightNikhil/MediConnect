package com.nikhil.springboot.MediConnect.security;

import com.nikhil.springboot.MediConnect.dto.Enums.Roles;
import com.nikhil.springboot.MediConnect.dto.UserDto;
import com.nikhil.springboot.MediConnect.entity.Patient;
import com.nikhil.springboot.MediConnect.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
@Slf4j
public class JwtService {

    @Value("${jwt.secret.key}")
    private String jwtSecretKey;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor((jwtSecretKey).getBytes(StandardCharsets.UTF_8));
    }

    public String createJwtToken(UserDto userdto) {

        return Jwts.builder()
                .signWith(getSecretKey())
                .subject(String.valueOf(userdto.getId()))
                .claim("role", userdto.getRole())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .compact();


    }

    public User getUserIdAndRoleFromToken(String token) {

        //jwt parser,verify the secret key
        JwtParser jwtParser = Jwts.parser()
                .verifyWith(getSecretKey())
                .build();

        // get claim through the verified parser
        Claims claims = jwtParser.parseSignedClaims(token)
                .getPayload();

        // get the id through claim
        User user = new Patient();
        user.setId(Long.valueOf(claims.getSubject()));
        user.setRole(Roles.valueOf(claims.get("role", String.class)));
        return user;
    }


}
