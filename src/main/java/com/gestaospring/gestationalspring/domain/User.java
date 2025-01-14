package com.gestaospring.gestationalspring.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
@Data
@Table("USERS")
public class User {
    @Column("PASSWORD")
    private String password;
    @Column("EMAIL")
    private String email;
    @Column("ID")
@Id private Long id;
@Column("NOME")
 private String nome;
 @MappedCollection(idColumn = "userId")
private List<Gasto> gastosID;
}
