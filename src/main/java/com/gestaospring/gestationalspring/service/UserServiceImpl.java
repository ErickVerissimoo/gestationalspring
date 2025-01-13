package com.gestaospring.gestationalspring.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.gestaospring.gestationalspring.domain.Gasto;
import com.gestaospring.gestationalspring.domain.User;
import com.gestaospring.gestationalspring.interfaces.UserService;
import com.gestaospring.gestationalspring.repositories.JdbcUserRepository;
import com.gestaospring.gestationalspring.repositories.UserRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
private final UserRepository repository;
private final JdbcUserRepository jdbcUserRepository;
    
@Override
    public BigDecimal getTotalGastos(User user) {

        return user.getGastos().stream().map(gasto -> gasto.getValor()).reduce(BigDecimal.ZERO, BigDecimal::add);  
        
    }
    @Override
 public User getUserByEmail(String email){
return Optional.ofNullable( repository.findByEmail(email)).orElseThrow(() -> new RuntimeException("User not found"));
 }
    @Override
    public Gasto addGasto(Gasto gasto) {
        User user = gasto.getUser();
 repository.save(user);
 return gasto;
    }
    @Override
    public Gasto getGastoById(Long id) {
        return repository.findById(id).map(User::getGastos).stream().collect(Collectors.toList()).get(0).get(0);
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
