package com.gestaospring.gestationalspring.service;

import org.springframework.http.ResponseCookie;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestaospring.gestationalspring.domain.User;
import com.gestaospring.gestationalspring.exception.EntityAlreadyExistsException;
import com.gestaospring.gestationalspring.interfaces.AuthService;
import com.gestaospring.gestationalspring.interfaces.JwtService;
import com.gestaospring.gestationalspring.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
private final UserRepository repository;
private final AuthenticationManager authenticationManager;
private final PasswordEncoder encoder;
private final JwtService jwtService;
@Override
public String authenticate(User user) {
   
    try{ 
         var authentication =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        ResponseCookie cookie = ResponseCookie.from("Bearer",  jwtService.createToken(authentication.getName())).httpOnly(true).maxAge(3600).path("/").build();
        return cookie.toString();

    }catch(AuthenticationException e) {
        throw e;

    }

    }
    



@Override
    public User register(User user) throws Exception {
        if(repository.existsByEmail(user.getEmail())) {
            throw new EntityAlreadyExistsException("Email já cadastrado");
        }
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
        
    }

}
