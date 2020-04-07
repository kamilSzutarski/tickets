package com.wsb.tickets.service.impl;

import com.wsb.tickets.domain.Role;
import com.wsb.tickets.repository.RoleRepository;
import com.wsb.tickets.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        return roleRepository.findAll();
    }
}
