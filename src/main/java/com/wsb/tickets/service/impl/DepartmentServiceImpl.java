package com.wsb.tickets.service.impl;

import com.wsb.tickets.domain.Department;
import com.wsb.tickets.repository.DepartmentRepository;
import com.wsb.tickets.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department save(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public Department getById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department with id: " + id + "is not found"));
    }

    @Override
    public void removeDepartment(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department editDepartment(Department department) {
        return departmentRepository.findById(department.getId()).map(departmentDB -> {
            if (!departmentDB.getShortName().equals(department.getShortName())
                    || (!departmentDB.getFullName().equals(department.getFullName()))) {
                departmentDB.setShortName(department.getShortName());
                departmentDB.setFullName(department.getFullName());
            }
            return departmentRepository.save(departmentDB);
        }).orElseThrow(() -> new EntityNotFoundException("Department with id doesn't exist"));
    }

    @Override
    public Page<Department> getPage(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }

    @Override
    public Page<Department> findByShortNameContaining(String shortName, Pageable pageable) {
        return departmentRepository.findByShortNameContaining(shortName, pageable);
    }

    @Override
    public Page<Department> findByFullNameContaining(String fullName, Pageable pageable) {
        return departmentRepository.findByFullNameContaining(fullName, pageable);
    }
}
