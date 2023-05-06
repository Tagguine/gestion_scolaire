package com.example.gestion_scolaire.dao;

import com.example.gestion_scolaire.entities.Etudiant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant,Long> {

    Page<Etudiant> findByClasseNomIgnoreCase(String classeNom, Pageable pageable);

    Page<Etudiant> findAll(Pageable pageable);

    Page<Etudiant> findByClasseEnseignantNomIgnoreCase(String enseignantNom, Pageable pageable);

    Page<Etudiant> findByClasseNomIgnoreCaseAndClasseEnseignantNomIgnoreCase(String classeNom, String enseignantNom, Pageable pageable);



}
