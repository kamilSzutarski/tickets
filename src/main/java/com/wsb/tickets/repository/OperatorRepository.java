package com.wsb.tickets.repository;

import com.wsb.tickets.domain.Operator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperatorRepository extends JpaRepository<Operator, Long> {

    Page<Operator> findByLoginContaining(String login, Pageable pageable);

    Page<Operator> findByCompanyContaining(String company, Pageable pageable);

    Page<Operator> findByNameContaining(String name, Pageable pageable);

    Page<Operator> findBySurnameContaining(String surname, Pageable pageable);
}
