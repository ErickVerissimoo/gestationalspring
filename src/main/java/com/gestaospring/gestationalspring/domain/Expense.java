package com.gestaospring.gestationalspring.domain;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("expense")
public class Expense {
    @Id
    private Long id;

    private String description;

    private Double value;

    private LocalDate date;


}
