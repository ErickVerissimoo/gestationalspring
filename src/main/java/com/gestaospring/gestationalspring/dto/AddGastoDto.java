package com.gestaospring.gestationalspring.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.Immutable;

import lombok.Data;
@Immutable
@Data
public class AddGastoDto {
private String descricao;
private Double valor;
private LocalDate data;
private Long userId;
}
