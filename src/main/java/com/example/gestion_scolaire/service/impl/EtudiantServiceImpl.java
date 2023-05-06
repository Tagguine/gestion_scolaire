package com.example.gestion_scolaire.service.impl;

import com.example.gestion_scolaire.dto.EtudiantDto;
import com.example.gestion_scolaire.dao.ClasseRepository;
import com.example.gestion_scolaire.dao.EnseignantRepository;
import com.example.gestion_scolaire.dao.EtudiantRepository;
import com.example.gestion_scolaire.service.EtudiantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class EtudiantServiceImpl implements EtudiantService {
    private EtudiantRepository etudiantRepository;
    private ClasseRepository classeRepository;
    private EnseignantRepository enseignantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository, ClasseRepository classeRepository, EnseignantRepository enseignantRepository) {
        this.etudiantRepository = etudiantRepository;
        this.classeRepository = classeRepository;
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public EtudiantDto save(EtudiantDto dto) {
        return EtudiantDto.fromEntity(etudiantRepository.save(EtudiantDto.toEntity(dto)));
    }

    @Override
    public EtudiantDto findById(Long id) {
        return etudiantRepository.findById(id)
                .map(EtudiantDto::fromEntity)
                .orElseThrow(()->new EntityNotFoundException("Aucun Etudiant avec l'ID="+id+" n'est été trouver dans la BDD"));
    }

    @Override
    public Page<EtudiantDto> findAll(Pageable pageable) {
        List<EtudiantDto> etudiantDtos = etudiantRepository.findAll().stream()
                .map(EtudiantDto::fromEntity)
                .collect(Collectors.toList());
        long totalEtudiants = etudiantDtos.stream().count();
        Pageable pageableEtudiants = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<EtudiantDto> pageEtudiants = new PageImpl<>(etudiantDtos, pageableEtudiants, totalEtudiants);
        return pageEtudiants;
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Etudiant ID is null");
            return;
        }
        etudiantRepository.deleteById(id);
    }

    @Override
    public Page<EtudiantDto> findByClasseNomIgnoreCase(String classeNom, Pageable pageable) {
        List<EtudiantDto> etudiantDtos = etudiantRepository.findByClasseNomIgnoreCase(classeNom, pageable)
                .stream()
                .map(EtudiantDto::fromEntity)
                .collect(Collectors.toList());

        long totalEtudiants = etudiantDtos.stream().count();
        Pageable pageableEtudiants = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<EtudiantDto> pageEtudiants = new PageImpl<>(etudiantDtos, pageableEtudiants, totalEtudiants);
        return pageEtudiants;
    }

    @Override
    public Page<EtudiantDto> findByClasseEnseignantNomIgnoreCase(String enseignantNom, Pageable pageable) {
        List<EtudiantDto> etudiantDtos = etudiantRepository.findByClasseEnseignantNomIgnoreCase(enseignantNom, pageable)
                .stream()
                .map(EtudiantDto::fromEntity)
                .collect(Collectors.toList());

        long totalEtudiants = etudiantDtos.stream().count();
        Pageable pageableEtudiants = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<EtudiantDto> pageEtudiants = new PageImpl<>(etudiantDtos, pageableEtudiants, totalEtudiants);
        return pageEtudiants;
    }

    @Override
    public Page<EtudiantDto> findByClasseNomIgnoreCaseAndClasseEnseignantNomIgnoreCase(String classeNom, String enseignantNom, Pageable pageable) {
        List<EtudiantDto> etudiantDtos = etudiantRepository.findByClasseNomIgnoreCaseAndClasseEnseignantNomIgnoreCase(classeNom,enseignantNom, pageable)
                .stream()
                .map(EtudiantDto::fromEntity)
                .collect(Collectors.toList());

        long totalEtudiants = etudiantDtos.stream().count();
        Pageable pageableEtudiants = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());
        Page<EtudiantDto> pageEtudiants = new PageImpl<>(etudiantDtos, pageableEtudiants, totalEtudiants);
        return pageEtudiants;
    }
}
