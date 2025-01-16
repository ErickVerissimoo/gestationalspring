package com.gestaospring.gestationalspring.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.gestaospring.gestationalspring.domain.Expense;
import com.gestaospring.gestationalspring.domain.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JdbcUserRepository {

    private final JdbcClient jdbcClient;

    private static final RowMapper<Expense> GASTO_ROW_MAPPER = (rs, rowNum) -> {
        Expense gasto = new Expense();
        gasto.setId(rs.getLong("ID"));
        gasto.setDescription(rs.getString("DESCRICAO"));
        gasto.setValue(rs.getDouble("VALOR"));
        gasto.setDate(rs.getDate("DATA").toLocalDate());
        
        return gasto;
    };

    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getLong("ID"));
        user.setName(rs.getString("NOME"));
        user.setEmail(rs.getString("EMAIL"));
        user.setPassword(rs.getString("PASSWORD"));
        return user;
    };

    public List<Expense> getGastosBelowValue(BigDecimal value) {
        String sql = "SELECT * FROM gasto WHERE valor < ?";
        return jdbcClient.sql(sql).param(value).query(GASTO_ROW_MAPPER).list();
    }

    public List<Expense> getGastosAboveValue(BigDecimal value) {
        String sql = "SELECT * FROM gasto WHERE valor > ?";
        return jdbcClient.sql(sql).param(value).query(GASTO_ROW_MAPPER).list();
    }

    public List<Expense> getGastosByValue(BigDecimal value) {
        String sql = "SELECT * FROM gasto WHERE valor = ?";
        return jdbcClient.sql(sql).param(value).query(GASTO_ROW_MAPPER).list();
    }

    public List<Expense> getGastosByExample(Expense gasto) {
        String sql = "SELECT * FROM gasto WHERE descricao LIKE ? AND valor = ?";
        return jdbcClient
                .sql(sql)
                .param("%" + gasto.getDescription() + "%")
                .param(gasto.getValue())
                .query(GASTO_ROW_MAPPER)
                .list();
    }

    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcClient.sql(sql).param(email).query(USER_ROW_MAPPER).optional();
    }
    public List<User> findAll(){
        return jdbcClient.sql("SELECT * FROM users").query(USER_ROW_MAPPER).list();
    }
}
