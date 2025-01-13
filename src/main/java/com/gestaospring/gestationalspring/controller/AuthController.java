package com.gestaospring.gestationalspring.controller;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestaospring.gestationalspring.dto.LoginDto;
import com.gestaospring.gestationalspring.interfaces.AuthService;
import com.gestaospring.gestationalspring.utils.IUserMapper;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    private final IUserMapper mapper;
@PostMapping("/login")
public ResponseEntity<Map<String, String>> loginController(@RequestBody LoginDto entity) {

       String token =  authService.authenticate(mapper.toEntity(entity));
        
       return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, token) .body(Map.of("message", "user logged in"));
}
@PostMapping("/register")
public ResponseEntity<Map<String, String>> registerController(@RequestBody LoginDto entity) throws Exception {
    
                 authService.register(mapper.toEntity(entity));

        return  ResponseEntity.ok().body(Map.of("message", "user registered"));


}
@PostMapping("/logout")
public ResponseEntity<Map<String, String>> logout(){
    ResponseCookie cook = ResponseCookie.from("Bearer", "null").maxAge(0).path("/").build();    
return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cook.toString()).body(Map.of("message","user log out"));
}
}