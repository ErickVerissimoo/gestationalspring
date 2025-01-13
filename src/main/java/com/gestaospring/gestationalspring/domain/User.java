package com.gestaospring.gestationalspring.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
@Data
@Table("users")
public class User {
    private String password;
    private String email;
@Id private Long id;
 private String nome;
private List<Gasto> gastos;
}
