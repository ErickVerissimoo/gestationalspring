package com.gestaospring.gestationalspring.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import com.gestaospring.gestationalspring.domain.Expense;

@Repository
public interface GastoRepository extends ListCrudRepository<Expense, Long> {
 

}
