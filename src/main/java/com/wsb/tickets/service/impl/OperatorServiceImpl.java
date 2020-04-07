package com.wsb.tickets.service.impl;

import com.wsb.tickets.domain.Operator;
import com.wsb.tickets.repository.DepartmentRepository;
import com.wsb.tickets.repository.OperatorRepository;
import com.wsb.tickets.repository.RoleRepository;
import com.wsb.tickets.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;

@Service
public class OperatorServiceImpl implements OperatorService {

    @Autowired
    private OperatorRepository operatorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Operator save(Operator operator, String... roleList) {
        operator.setPassword(passwordEncoder.encode(operator.getPassword()));
        operator.setRoles(roleRepository.findByNameIn(Arrays.asList(roleList)));
        operator.setDepartment(departmentRepository.findByShortName(operator.getDepartment().getShortName()));
        return operatorRepository.save(operator);
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
            if (!operatorDB.getName().equals(operator.getName())
                    || (!operatorDB.getSurname().equals(operator.getSurname()))
                    || (!operatorDB.getCompany().equals(operator.getCompany()))) {
                operatorDB.setName(operator.getName());
                operatorDB.setSurname(operator.getSurname());
                operatorDB.setCompany(operator.getCompany());
            }
            return operatorRepository.save(operatorDB);
        })
                .orElseThrow(() -> new EntityNotFoundException("Operator with id doesn't exist"));
    }
}
