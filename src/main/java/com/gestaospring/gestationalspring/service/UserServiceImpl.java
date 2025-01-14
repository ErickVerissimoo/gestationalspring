package com.gestaospring.gestationalspring.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.gestaospring.gestationalspring.domain.Gasto;
import com.gestaospring.gestationalspring.domain.User;
import com.gestaospring.gestationalspring.interfaces.JwtService;
import com.gestaospring.gestationalspring.interfaces.UserService;
import com.gestaospring.gestationalspring.repositories.GastoRepository;
import com.gestaospring.gestationalspring.repositories.JdbcUserRepository;
import com.gestaospring.gestationalspring.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
private final UserRepository repository;
private final JdbcUserRepository jdbcUserRepository;
private final GastoRepository gastoRepository;
    private final JwtService jwt;
@Override
    public BigDecimal getTotalGastos(User user) {

        return null;
        
    }
    @Override
 public User getUserByEmail(String email){
return Optional.ofNullable( repository.findByEmail(email)).orElseThrow(() -> new RuntimeException("User not found"));
 }
    @Override
    public Gasto addGasto(Gasto gasto, String token) {
        var use = jdbcUserRepository.findByEmail(jwt.getEmail(token)).orElseThrow();
        gasto.setUser_id(use.getId());
       use.getGastosID().add(gasto);
 repository.save(use);
 gastoRepository.save(gasto);
 return gasto;
    }
    @Override
    public Gasto getGastoById(Long id) {
        return null;
    }
    @Override
    public List<Gasto> getGastoByExample(Gasto gasto) {
        
        return jdbcUserRepository.getGastosByExample(gasto);
    }
    @Override
    public List<Gasto> getGastoAboveValue(BigDecimal value) {
        return jdbcUserRepository.getGastosAboveValue(value);
    }
    @Override
    public List<Gasto> getGastoBelowValue(BigDecimal value) {
return jdbcUserRepository.getGastosBelowValue(value);
    }
    @Override
    public List<Gasto> getGastoByValue(BigDecimal value) {
        return jdbcUserRepository.getGastosByValue(value);
    }
}
