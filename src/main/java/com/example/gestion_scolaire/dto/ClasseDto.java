package com.example.gestion_scolaire.dto;

import com.example.gestion_scolaire.entities.Classe;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClasseDto {

    private Long id;

    private String nom;

    private EnseignantDto enseignant;

    public static ClasseDto fromEntity(Classe classe) {
        if (classe == null) {
            return null;
        }
        return ClasseDto.builder()
                .id(classe.getId())
                .nom(classe.getNom())
                .enseignant(EnseignantDto.fromEntity(classe.getEnseignant()))
                .build();
    }

    public static Classe toEntity(ClasseDto dto) {
        if (dto == null) {
            return null;
        }
        return Classe.builder()
                .id(dto.getId())
                .nom(dto.getNom())
                .enseignant(EnseignantDto.toEntity(dto.getEnseignant()))
                .build();
    }
}
