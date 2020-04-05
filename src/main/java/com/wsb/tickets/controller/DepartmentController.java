package com.wsb.tickets.controller;

import com.wsb.tickets.domain.Department;
import com.wsb.tickets.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.save(department);
    }

    @GetMapping("/id/{id}")
    public Department getById(@PathVariable Long id) {
        return departmentService.getById(id);
    }

    @DeleteMapping
    public void removeDepartment(Long id) {
        departmentService.removeDepartment(id);
    }

    @PutMapping
    public Department editDepartment(Department department) {
        return departmentService.editDepartment(department);
    }

    @GetMapping
    public Page<Department> departmentPage(@RequestParam Integer page, @RequestParam Integer size) {
        return departmentService.getPage(PageRequest.of(page, size));
    }

    @GetMapping("/shortName/{shortName}")
    public Page<Department> findByShortNameContaining(@PathVariable String shortName, @RequestParam Integer page, @RequestParam Integer size) {
        return departmentService.findByShortNameContaining(shortName, PageRequest.of(page, size));
    }

    @GetMapping("/fullName/{fullName}")
    public Page<Department> findByFullNameContaining(@PathVariable String fullName, @RequestParam Integer page, @RequestParam Integer size) {
        return departmentService.findByFullNameContaining(fullName, PageRequest.of(page, size));
    }
}
