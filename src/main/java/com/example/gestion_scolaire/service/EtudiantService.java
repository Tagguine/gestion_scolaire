package com.example.gestion_scolaire.service;

import com.example.gestion_scolaire.dto.EtudiantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EtudiantService {

    EtudiantDto save(EtudiantDto dto);

    EtudiantDto findById(Long id);

    Page<EtudiantDto> findAll(Pageable pageable);

    void delete(Long id);

    Page<EtudiantDto> findByClasseNomIgnoreCase(String classeNom, Pageable pageable);

    Page<EtudiantDto> findByClasseEnseignantNomIgnoreCase(String enseignantNom, Pageable pageable);

    Page<EtudiantDto> findByClasseNomIgnoreCaseAndClasseEnseignantNomIgnoreCase(String classeNom, String enseignantNom, Pageable pageable);

}
