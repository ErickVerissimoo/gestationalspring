package com.gestaospring.gestationalspring.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("users")
public class User {
    @Id
    private Long id;

    private String name;

    private String email;

    private String password;
    @MappedCollection(idColumn = "user_id")
    private List<Expense> expenses;
}
