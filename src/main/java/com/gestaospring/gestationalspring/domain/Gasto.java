package com.gestaospring.gestationalspring.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
@Data
@Table("GASTO")
public class Gasto {
    @Column("ID")
@Id private Long id;
@Column("DESCRICAO")
private String descricao;
@Column("VALOR")
private BigDecimal valor;
@Column("DATA")
private LocalDate data;
@Column(value = "USER_ID") 
private Long user_id;
}
