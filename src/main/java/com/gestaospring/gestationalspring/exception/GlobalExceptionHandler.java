package com.gestaospring.gestationalspring.exception;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
@ExceptionHandler(EntityAlreadyExistsException.class)
public ResponseEntity<String> handleException(Exception e) {
    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Entidade já existente");

}
@ExceptionHandler(AuthenticationException.class)
public ResponseEntity<Map<String, String>> handleException(AuthenticationException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("message", "Usuário ou senha inválidos"));

}
@ExceptionHandler(EntityNotFoundException.class)
public ResponseEntity<String> handleException(EntityNotFoundException e) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entidade não encontrada");
}}