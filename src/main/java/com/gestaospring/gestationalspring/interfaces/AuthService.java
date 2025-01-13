package com.gestaospring.gestationalspring.interfaces;

import com.gestaospring.gestationalspring.domain.User;

public interface AuthService {
String authenticate(User user);
User register(User user) throws Exception;
}
