package com.gestaospring.gestationalspring.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.gestaospring.gestationalspring.domain.Gasto;
import com.gestaospring.gestationalspring.domain.User;

public interface UserService {
    BigDecimal getTotalGastos(User user);
User getUserByEmail(String email);
Gasto addGasto(Gasto gasto);
Gasto getGastoById(Long id);
List<Gasto> getGastoByExample(Gasto gasto);
List<Gasto> getGastoAboveValue(BigDecimal value);
List<Gasto> getGastoBelowValue(BigDecimal value);
List<Gasto> getGastoByValue(BigDecimal value);
}
