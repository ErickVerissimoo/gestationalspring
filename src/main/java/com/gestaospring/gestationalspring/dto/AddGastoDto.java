package com.gestaospring.gestationalspring.dto;

import java.time.LocalDate;

import org.springframework.data.annotation.Immutable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
@Immutable
@Data
public class AddGastoDto {
private String descricao;
private Double valor;
private LocalDate data;
@JsonIgnore(true)
private UserDto dto;
}
