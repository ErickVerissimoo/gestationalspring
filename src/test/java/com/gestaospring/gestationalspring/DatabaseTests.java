package com.gestaospring.gestationalspring;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;

import com.gestaospring.gestationalspring.domain.Expense;
import com.gestaospring.gestationalspring.domain.User;
import com.gestaospring.gestationalspring.repositories.JdbcUserRepository;
import com.gestaospring.gestationalspring.repositories.UserRepository;
@DataJdbcTest
@Import(JdbcUserRepository.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DatabaseTests {
 
            
        
    @Autowired
    UserRepository userRepository;
    @Autowired JdbcUserRepository jdbc;
 
    List<User> users;
    @BeforeEach
void setup() {
    User user = new User();
    user.setEmail("user144@gmai.com");
    user.setName("myUser");
    user.setPassword("user");
    var exp = new Expense();
    exp.setDate(LocalDate.now());
    exp.setValue(22.3);
    exp.setDescription("some description");
    user.getExpenses().add(exp);
    userRepository.save(user);
}
@Test 
void test(){
    // [User(id=1, name=myUser, email=user144@gmai.com, password=user, expenses=[])]
    System.out.println(userRepository.findAll());
}
}