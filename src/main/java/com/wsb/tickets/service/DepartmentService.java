package com.wsb.tickets.service;

import com.wsb.tickets.domain.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

public interface DepartmentService {

    Department save(Department department);

    Department getById(Long id);

    void removeDepartment(Long id);

    Department editDepartment(Department department);

    Page<Department> getPage(@PageableDefault Pageable pageable);

    Page<Department> findByShortNameContaining(String shortName, Pageable pageable);

    Page<Department> findByFullNameContaining(String fullName, Pageable pageable);
}
