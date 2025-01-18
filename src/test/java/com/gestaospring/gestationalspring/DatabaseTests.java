package com.gestaospring.gestationalspring;

import java.util.List;

import org.instancio.Binding;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.context.annotation.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
   for(int i =0; i<10;i++){
    userRepository.save(Instancio.of(User.class).ignore(Binding.fieldBinding( "id")). ignore(Binding.fieldBinding(Expense.class, "id")).create());
   }

}
@Test 
void test(){
   var value = 30.2d;
Pageable pageable = Pageable.ofSize(10);
Page<User> page = userRepository.findAll(pageable);
var paginado = page.get(). flatMap(c -> c.getExpenses().stream()).filter(o -> o.getValue()>30d).toList();
   var menor = userRepository.findAll().stream().flatMap(c -> c.getExpenses().stream()).filter(c -> c.getValue()<30d).toList();
System.out.println(menor);
}
}