package com.gestaospring.gestationalspring.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class SqlDestroy {
private static final String DROP_USER = "DROP TABLE IF EXISTS users CASCADE";
private static final String DROP_GASTO = "DROP TABLE IF EXISTS gasto CASCADE";
@Autowired
private  JdbcClient client;

@PreDestroy
public void destroy() {
    client.sql(DROP_GASTO).update();

client.sql(DROP_USER).update();
}
}
