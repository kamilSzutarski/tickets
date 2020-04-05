package com.wsb.tickets.service;

import com.wsb.tickets.domain.Operator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public interface OperatorService {

    Operator save(Operator operator, String... roleList);

    Operator getById(Long id);

    Page<Operator> getPage(@PageableDefault Pageable pageable);

    Page<Operator> findByLoginContaining(String login, Pageable pageable);

    Page<Operator> findByCompanyContaining(String company, Pageable pageable);

    Page<Operator> findByNameContaining(String name, Pageable pageable);

    Page<Operator> findBySurnameContaining(String surname, Pageable pageable);

    void removeOperator(Long id);

    Operator editOperator(Operator operator);
}
