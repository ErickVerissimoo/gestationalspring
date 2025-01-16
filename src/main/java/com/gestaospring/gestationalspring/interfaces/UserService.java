package com.gestaospring.gestationalspring.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.gestaospring.gestationalspring.domain.Expense;
import com.gestaospring.gestationalspring.domain.User;

public interface UserService {
    BigDecimal getTotalGastos(User user);
User getUserByEmail(String email);
Expense addGasto(Expense gasto, String token);
Expense getGastoById(Long id);
List<Expense> getGastoByExample(Expense gasto);
List<Expense> getGastoAboveValue(BigDecimal value);
List<Expense> getGastoBelowValue(BigDecimal value);
List<Expense> getGastoByValue(BigDecimal value);
}
