package com.example.gestion_scolaire.web;

import com.example.gestion_scolaire.dto.EtudiantDto;
import com.example.gestion_scolaire.service.ClasseService;
import com.example.gestion_scolaire.service.EnseignantService;
import com.example.gestion_scolaire.service.EtudiantService;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Data
@AllArgsConstructor
public class EtudiantController {
    private EtudiantService etudiantService;

    private EnseignantService enseignantService;

    private ClasseService classeService;


    @GetMapping(path = "/etudiants")
    public ResponseEntity<Page<EtudiantDto>> getAllEtudiants(@RequestParam(name = "classeNom", required = false) String classeNom,
                                                             @RequestParam(name = "enseignantNom", required = false) String enseignantNom,
                                                             @RequestParam(defaultValue = "0") int page,
                                                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);

        if (classeNom == null && enseignantNom == null) {
            return ResponseEntity.ok(etudiantService.findAll(pageable));
        } else if (classeNom != null && enseignantNom == null) {
            return ResponseEntity.ok(etudiantService.findByClasseNomIgnoreCase(classeNom, pageable));
        } else if (classeNom == null && enseignantNom != null) {
            return ResponseEntity.ok(etudiantService.findByClasseEnseignantNomIgnoreCase(enseignantNom, pageable));
        } else {
            return ResponseEntity.ok(etudiantService.findByClasseNomIgnoreCaseAndClasseEnseignantNomIgnoreCase(classeNom, enseignantNom, pageable));
        }
    }
}
