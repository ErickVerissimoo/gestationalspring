package com.gestaospring.gestationalspring.repositories;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import com.gestaospring.gestationalspring.domain.Gasto;
import com.gestaospring.gestationalspring.domain.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JdbcUserRepository {

    private final JdbcClient jdbcClient;

    private static final RowMapper<Gasto> GASTO_ROW_MAPPER = (rs, rowNum) -> {
        Gasto gasto = new Gasto();
        gasto.setId(rs.getLong("id"));
        gasto.setDescricao(rs.getString("descricao"));
        gasto.setValor(rs.getBigDecimal("valor"));
        gasto.setData(rs.getDate("data").toLocalDate());
        gasto.setUserId(rs.getLong("user_id"));
        return gasto;
    };

    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) -> {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setNome(rs.getString("nome"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        return user;
    };

    public List<Gasto> getGastosBelowValue(BigDecimal value) {
        String sql = "SELECT * FROM gasto WHERE valor < ?";
        return jdbcClient.sql(sql).param(value).query(GASTO_ROW_MAPPER).list();
    }

    public List<Gasto> getGastosAboveValue(BigDecimal value) {
        String sql = "SELECT * FROM gasto WHERE valor > ?";
        return jdbcClient.sql(sql).param(value).query(GASTO_ROW_MAPPER).list();
    }

    public List<Gasto> getGastosByValue(BigDecimal value) {
        String sql = "SELECT * FROM gasto WHERE valor = ?";
        return jdbcClient.sql(sql).param(value).query(GASTO_ROW_MAPPER).list();
    }

    public List<Gasto> getGastosByExample(Gasto gasto) {
        String sql = "SELECT * FROM gasto WHERE descricao LIKE ? AND valor = ?";
        return jdbcClient
                .sql(sql)
                .param("%" + gasto.getDescricao() + "%")
                .param(gasto.getValor())
                .query(GASTO_ROW_MAPPER)
                .list();
    }

    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcClient.sql(sql).param(email).query(USER_ROW_MAPPER).optional();
    }
}
