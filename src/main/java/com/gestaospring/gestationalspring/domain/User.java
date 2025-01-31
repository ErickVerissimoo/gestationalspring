package com.gestaospring.gestationalspring.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("users")
@AllArgsConstructor
public class User {
    @Id
    private Long id;

    private String name;

    private String email;

    private String password;
    @MappedCollection(idColumn = "users_id")
    private Set<Expense> expenses;
    public User(){
        expenses = new HashSet<>();
    }
    
  
    
    }

