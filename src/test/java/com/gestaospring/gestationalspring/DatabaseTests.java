package com.gestaospring.gestationalspring;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.gestaospring.gestationalspring.domain.User;
import com.gestaospring.gestationalspring.repositories.GastoRepository;
import com.gestaospring.gestationalspring.repositories.JdbcUserRepository;
import com.gestaospring.gestationalspring.repositories.UserRepository;
import com.gestaospring.gestationalspring.service.JwtServiceImpl;
import com.gestaospring.gestationalspring.service.UserServiceImpl;
@SpringBootTest
@ActiveProfiles("test")
public class DatabaseTests {
 
    @Autowired
    JdbcUserRepository  jdbcUserRepository;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    UserRepository userRepository;
    @Autowired
    JwtServiceImpl jwt;
    @Autowired
    GastoRepository gastoRepo;
    List<User> users;
    @BeforeEach
void test() {
users = new ArrayList<>();    
    User user = new User();
    user.setEmail("erickverissimodasilva144@gmai.com");
    user.setNome("erick");
    user.setPassword("erick");
    userRepository.save(user);
}
@Test 
void testagem(){
    

    System.out.println(jdbcUserRepository.findAll());
}
}

