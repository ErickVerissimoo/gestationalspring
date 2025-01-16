package com.gestaospring.gestationalspring;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;

import com.gestaospring.gestationalspring.domain.Expense;
import com.gestaospring.gestationalspring.domain.User;
import com.gestaospring.gestationalspring.repositories.UserRepository;
@DataJdbcTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DatabaseTests {
 
            
        
    @Autowired
    UserRepository userRepository;
    
 
    List<User> users;
    @BeforeEach
void setup() {
    User user = new User();
    user.setEmail("user144@gmai.com");
    user.setName("myUser");
    user.setPassword("user");
    var exp = new Expense();
    exp.setDate(LocalDate.now());
    exp.setValue(22.2);
    exp.setDescription("some description");
    user.getExpenses().add(exp);
    userRepository.save(user);
}
@Test 
void test(){
    System.out.println(userRepository.findAll().stream().flatMap(c -> c.getExpenses().stream()).map(Expense::getValue).toList());
}
}