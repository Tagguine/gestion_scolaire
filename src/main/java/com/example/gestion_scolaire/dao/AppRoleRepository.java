package com.example.gestion_scolaire.dao;

import com.example.gestion_scolaire.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppRoleRepository extends JpaRepository<AppRole,Long> {
    AppRole findByRoleName(String roleName);


}
