package com.example.gestion_scolaire.dto;


import com.example.gestion_scolaire.entities.Etudiant;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EtudiantDto {

    private Long id;

    private String nom;

    private String prenom;

    private ClasseDto classe;

    public static EtudiantDto fromEntity(Etudiant etudiant) {
        if (etudiant == null) {
            return null;
        }
        return EtudiantDto.builder()
                .id(etudiant.getId())
                .nom(etudiant.getNom())
                .prenom(etudiant.getPrenom())
                .classe(ClasseDto.fromEntity(etudiant.getClasse()))
                .build();
    }

    public static Etudiant toEntity(EtudiantDto dto) {
        if (dto == null) {
            return null;
        }
        Etudiant etudiant=new Etudiant();
        etudiant.setId(dto.getId());
        etudiant.setPrenom(dto.getPrenom());
        etudiant.setNom(dto.getNom());
        etudiant.setClasse(ClasseDto.toEntity(dto.getClasse()));

        return etudiant;
    }

}
