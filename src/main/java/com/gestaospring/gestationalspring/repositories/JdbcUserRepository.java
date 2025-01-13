package com.gestaospring.gestationalspring.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.gestaospring.gestationalspring.domain.Gasto;
import com.gestaospring.gestationalspring.domain.User;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Repository
public class JdbcUserRepository {
private final JdbcClient jdbcClient;
public List <Gasto> getGastosBelowValue(BigDecimal value) {
return    jdbcClient.sql("SELECT * FROM gasto WHERE valor < ?").param(value).query(Gasto.class).list();
}
public List <Gasto> getGastosAboveValue(BigDecimal value) {
return jdbcClient.sql("SELECT * FROM gasto WHERE valor > ?").param(value).query(Gasto.class).list();
}
public List <Gasto> getGastosByValue(BigDecimal value) {
return jdbcClient.sql("SELECT * FROM gasto WHERE valor = ?").param(value).query(Gasto.class).list();
}
public List<Gasto> getGastosByExample(Gasto gasto) {
    String sql = "SELECT descricao, valor FROM gasto WHERE descricao LIKE ? AND valor = ?";
    return jdbcClient.sql(sql).param(gasto.getDescricao()).param(gasto.getValor()).query(Gasto.class).list();
}
public User findByEmail(String email) {
    return jdbcClient.sql("SELECT * FROM users WHERE email = ?").param(email).query(User.class).single();

}
}