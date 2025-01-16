package com.gestaospring.gestationalspring.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaospring.gestationalspring.domain.Expense;
import com.gestaospring.gestationalspring.interfaces.UserService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/user/gastos")
public class UserController {
private final UserService   userService;

@PostMapping
public ResponseEntity<Map<String, String>> addGasto(@RequestBody Expense gasto, @CookieValue(value = "Bearer", defaultValue = "not cookie founded") String token) {
    userService.addGasto(gasto, token);
    
    return ResponseEntity.ok(Map.of("message", "Gasto adicionado com sucesso"));
}}
