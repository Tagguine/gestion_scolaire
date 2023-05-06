package com.example.gestion_scolaire.service;


import com.example.gestion_scolaire.entities.AppRole;
import com.example.gestion_scolaire.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String password, String rePwd);
    AppRole saveNewRole(String roleName, String description);
    void addRoleToUser(String username, String roleName);
    void removeRoleFromUser(String username, String roleName);
    AppUser loadUserByUsername(String username);
}
