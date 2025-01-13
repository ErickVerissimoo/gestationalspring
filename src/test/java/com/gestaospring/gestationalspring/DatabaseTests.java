package com.gestaospring.gestationalspring;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import com.gestaospring.gestationalspring.repositories.JdbcUserRepository;
@DataJdbcTest
@Import(JdbcUserRepository.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DatabaseTests {
    @Autowired
    JdbcUserRepository  jdbcUserRepository;
  
@Test
void test() {
    var e  = jdbcUserRepository.getGastosAboveValue(BigDecimal.valueOf(1000));
e.forEach(System.out::println);

}
@BeforeEach
void setUp() {


}
}

