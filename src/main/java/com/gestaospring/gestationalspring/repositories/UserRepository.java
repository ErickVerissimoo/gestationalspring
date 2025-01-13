package com.gestaospring.gestationalspring.repositories;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.gestaospring.gestationalspring.domain.User;
@Repository
public interface UserRepository extends ListCrudRepository<User, Long> {
    User findByEmail(String email);
    boolean existsByEmail(String email);    
    Optional<User> findByNome(String name);

}
