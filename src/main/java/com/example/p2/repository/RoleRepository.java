package com.example.p2.repository;

import com.example.p2.model.ERole;
import com.example.p2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(ERole role);
}
