package com.gestaospring.gestationalspring.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.gestaospring.gestationalspring.interfaces.JwtService;
@Service
public class JwtServiceImpl implements JwtService {
    private static final Algorithm algorithm = Algorithm.HMAC256("minha chave secreta");



public String createToken(String email) {
    return JWT.create()
            .withSubject(email)
            .withExpiresAt(new Date(System.currentTimeMillis() + 60000))
            .sign(algorithm);
}
public String getEmail(String token) {
    return JWT.require(algorithm).build().verify(token).getSubject();



}

public boolean isValid(String token) {
    try {
        JWT.require(algorithm).build().verify(token);
        return true;
    } catch (Exception e) {
        return false;
    }
}
public boolean isExpired(String token) {
    Date expiration = JWT.require(algorithm).build().verify(token).getExpiresAt();
    return expiration.before(new Date());


}



}