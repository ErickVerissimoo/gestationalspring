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
        gasto.setId(rs.getLong("id"));
        gasto.setDescription(rs.getString("descricao"));
        gasto.setValue(rs.getDouble("valor"));
        gasto.setDate(rs.getDate("data").toLocalDate());

        
        return gasto;
    };

    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> {
        return User.builder().id(rs.getLong("id")).email(rs.getString("email")).password(rs.getString("password")) .build();
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
        return jdbcClient.sql("c.name, c.email, c.password, p.description, p.value, p.date from users c inner join expense p on c.id = p.users_id").query(User.class).list();
    }
}
