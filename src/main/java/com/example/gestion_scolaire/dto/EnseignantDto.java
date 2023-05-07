package com.example.gestion_scolaire.dto;

import com.example.gestion_scolaire.entities.Enseignant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnseignantDto {

    private Long id;
    private String nom;
    private String prenom;
    public static EnseignantDto fromEntity(Enseignant enseignant) {
        if (enseignant == null) {
            return null;
        }
        return EnseignantDto.builder()
                .id(enseignant.getId())
                .nom(enseignant.getNom())
                .prenom(enseignant.getPrenom())
                .build();
    }

    public static Enseignant toEntity(EnseignantDto dto) {
        if (dto == null) return null;
        return Enseignant.builder()
                .id(dto.getId())
                .prenom(dto.getPrenom())
                .nom(dto.getNom())
                .build();
    }

}
