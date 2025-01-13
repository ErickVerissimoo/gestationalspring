package com.gestaospring.gestationalspring.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
@Data
@Table("gasto")
public class Gasto {
@Id private Long id;
private String descricao;
private BigDecimal valor;
private LocalDate data; 
private Long userId;
}
