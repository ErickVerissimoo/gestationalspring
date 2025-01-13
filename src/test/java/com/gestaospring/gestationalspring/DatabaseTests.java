package com.gestaospring.gestationalspring;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.gestaospring.gestationalspring.repositories.GastoRepository;
import com.gestaospring.gestationalspring.repositories.JdbcUserRepository;
import com.gestaospring.gestationalspring.repositories.UserRepository;
import com.gestaospring.gestationalspring.service.JwtServiceImpl;
import com.gestaospring.gestationalspring.service.UserServiceImpl;
@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DatabaseTests {
    @MockitoBean
    JdbcUserRepository  jdbcUserRepository;
    @Autowired
    UserServiceImpl userService;
    @MockitoBean
    UserRepository userRepository;
    @MockitoBean
    JwtServiceImpl jwt;
    @MockitoBean
    GastoRepository gastoRepo;
@Test
void test() {
    var e  = jdbcUserRepository.getGastosAboveValue(BigDecimal.valueOf(100));
    assert e !=null :"nao pode ser null";
System.out.println(e.get(0)==null);
}

@BeforeAll
void setUp() {

}
}

