package com.example.blog.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

@Service
public class JwtProvider {

    public String generateToken(Authentication authentication){
        User principal = (User) authentication.getPrincipal();
        return Jwts.builder()
                .setSubject(principal.getUsername())
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.ES512))
                .compact();
    }

    public boolean validateToken(String jwt){
        Jwts.parser().setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.ES512))
                .parseClaimsJwt(jwt);
        return true;
    }

    public String getUsernameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.secretKeyFor(SignatureAlgorithm.ES512))
                .parseClaimsJwt(token)
                .getBody();

        return claims.getSubject();
    }
}
