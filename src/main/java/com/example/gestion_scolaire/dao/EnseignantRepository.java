package com.example.gestion_scolaire.dao;

import com.example.gestion_scolaire.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {

}
