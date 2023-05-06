package com.example.gestion_scolaire;

import com.example.gestion_scolaire.entities.Classe;
import com.example.gestion_scolaire.entities.Etudiant;
import com.example.gestion_scolaire.dao.EtudiantRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GestionStagiaireApplicationTests {
        @Autowired
        private EtudiantRepository etudiantRepository;

        @org.junit.Test
        public void shouldSaveCategoryWithSuccess() {
            Classe classe1=Classe.builder()
                    .nom("classe1")
                    .build();
            Etudiant expectedEtudiant = Etudiant.builder()
                    .prenom("reda")
                    .nom("bouganfou")
                    .classe(classe1)
                    .build();
            Etudiant savedEtudiant=etudiantRepository.save(expectedEtudiant);

            assertNotNull(savedEtudiant);
            assertNotNull(savedEtudiant.getId());
            assertEquals(expectedEtudiant.getPrenom(), savedEtudiant.getPrenom());
            assertEquals(expectedEtudiant.getNom(), savedEtudiant.getNom());
            assertEquals(expectedEtudiant.getClasse().getId(), savedEtudiant.getClasse().getId());
        }

        @org.junit.Test
        public void shouldUpdateCategoryWithSuccess() {
            Classe classe2=Classe.builder()
                    .nom("classe2")
                    .build();
            Etudiant expectedEtudiant = Etudiant.builder()
                    .prenom("moussa")
                    .nom("bouganfou")
                    .classe(classe2)
                    .build();

            Etudiant savedEtudiant = etudiantRepository.save(expectedEtudiant);

            Etudiant etudiantToUpdate = savedEtudiant;
            etudiantToUpdate.setNom("nom updated");

            savedEtudiant = etudiantRepository.save(etudiantToUpdate);

            assertNotNull(etudiantToUpdate);
            assertNotNull(etudiantToUpdate.getId());
            assertEquals(etudiantToUpdate.getNom(), savedEtudiant.getNom());
            assertEquals(etudiantToUpdate.getPrenom(), savedEtudiant.getPrenom());
            assertEquals(etudiantToUpdate.getClasse().getId(), savedEtudiant.getClasse().getId());
        }

    }
