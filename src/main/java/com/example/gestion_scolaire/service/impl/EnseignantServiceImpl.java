package com.example.gestion_scolaire.service.impl;

import com.example.gestion_scolaire.dto.EnseignantDto;
import com.example.gestion_scolaire.dao.EnseignantRepository;
import com.example.gestion_scolaire.service.EnseignantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class EnseignantServiceImpl implements EnseignantService {

    private EnseignantRepository enseignantRepository;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public EnseignantDto save(EnseignantDto dto) {
        return EnseignantDto.fromEntity(enseignantRepository.save(EnseignantDto.toEntity(dto)));
    }
}
