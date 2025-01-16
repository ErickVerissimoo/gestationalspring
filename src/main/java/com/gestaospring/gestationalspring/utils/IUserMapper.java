package com.gestaospring.gestationalspring.utils;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.gestaospring.gestationalspring.domain.User;
import com.gestaospring.gestationalspring.dto.LoginDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IUserMapper {
    @Mapping(target = "email", source = "email")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "name", source = "name")
User toEntity(LoginDto dto);

@Mapping(target = "email", source = "email")
@Mapping(target = "password", source = "password")
@Mapping(target = "name", source = "name")
LoginDto toDto(User user);

}
