package com.gestaospring.gestationalspring.interfaces;

public interface JwtService {
String createToken(String email);
boolean isValid(String token);
boolean isExpired(String token);
String getEmail(String token);

}
