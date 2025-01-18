package com.gestaospring.gestationalspring.repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.gestaospring.gestationalspring.domain.User;
@Repository
public interface UserRepository extends ListPagingAndSortingRepository<User, Long>, ListCrudRepository<User, Long> {
    @Query
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);    
    Optional<User> findByName(String name);

}
