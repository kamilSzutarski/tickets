package com.wsb.tickets.repository;

import com.wsb.tickets.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
    Set<Role> findByNameIn(List<String> roleList); // select * from role where name in (role1, role2)
}
