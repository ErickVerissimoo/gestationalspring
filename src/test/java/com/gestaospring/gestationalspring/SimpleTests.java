package com.gestaospring.gestationalspring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gestaospring.gestationalspring.interfaces.JwtService;

@ExtendWith(MockitoExtension.class)
public class SimpleTests {
@InjectMocks
JwtService jwtService;
@Test
void test() {
    var token = jwtService.createToken("erick@gmail.com");
    
System.out.println(token);

}}
