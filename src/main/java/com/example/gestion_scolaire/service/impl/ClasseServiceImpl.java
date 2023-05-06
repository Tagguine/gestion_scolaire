package com.example.gestion_scolaire.service.impl;

import com.example.gestion_scolaire.dto.ClasseDto;
import com.example.gestion_scolaire.dao.ClasseRepository;
import com.example.gestion_scolaire.service.ClasseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional(rollbackOn = Exception.class)
@Service
@Slf4j
public class ClasseServiceImpl implements ClasseService {
    private ClasseRepository classeRepository;

    public ClasseServiceImpl(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public ClasseDto save(ClasseDto dto) {
        return ClasseDto.fromEntity(classeRepository.save(ClasseDto.toEntity(dto)));
    }
}
