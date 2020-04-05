package com.wsb.tickets.service.impl;

import com.wsb.tickets.domain.Operator;
import com.wsb.tickets.repository.OperatorRepository;
import com.wsb.tickets.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    OperatorRepository operatorRepository;

    @Override
    public Operator save(Operator operator, String... roleList) {
        return null;
    }

    @Override
    public Operator getById(Long id) {
        return operatorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Operator with id:" + id + "is not found"));
    }

    @Override
    public Page<Operator> getPage(Pageable pageable) {
        return operatorRepository.findAll(pageable);
    }

    @Override
    public Page<Operator> findByLoginContaining(String login, Pageable pageable) {
        return operatorRepository.findByLoginContaining(login, pageable);
    }

    @Override
    public Page<Operator> findByCompanyContaining(String company, Pageable pageable) {
        return operatorRepository.findByCompanyContaining(company, pageable);
    }

    @Override
    public Page<Operator> findByNameContaining(String name, Pageable pageable) {
        return operatorRepository.findByNameContaining(name, pageable);
    }

    @Override
    public Page<Operator> findBySurnameContaining(String surname, Pageable pageable) {
        return operatorRepository.findBySurnameContaining(surname, pageable);
    }

    @Override
    public void removeOperator(Long id) {
        operatorRepository.deleteById(id);
    }

    // TODO department
    @Override
    public Operator editOperator(Operator operator) {
        return operatorRepository.findById(operator.getId()).map(operatorDB -> {
            if (!operatorDB.getName().equals(operator.getName())) {
                operatorDB.setName(operator.getName());
            } else if (!operatorDB.getSurname().equals(operator.getSurname())) {
                operatorDB.setSurname(operator.getSurname());
            } else if (!operatorDB.getCompany().equals(operator.getCompany())) {
                operatorDB.setCompany(operator.getCompany());
            }
            return operatorRepository.save(operatorDB);
        })
                .orElseThrow(() -> new EntityNotFoundException("Operator with id doesn't exist"));
    }
}
