package com.wsb.tickets.repository;

import com.wsb.tickets.domain.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Page<Department> findByShortNameContaining(String shortName, Pageable pageable);

    Page<Department> findByFullNameContaining(String fullName, Pageable pageable);

    Department findByShortName(String name);
}
