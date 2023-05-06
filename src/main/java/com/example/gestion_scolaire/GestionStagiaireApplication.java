package com.example.gestion_scolaire;

import com.example.gestion_scolaire.dto.ClasseDto;
import com.example.gestion_scolaire.dto.EnseignantDto;
import com.example.gestion_scolaire.dto.EtudiantDto;
import com.example.gestion_scolaire.entities.Classe;
import com.example.gestion_scolaire.entities.Enseignant;
import com.example.gestion_scolaire.entities.Etudiant;
import com.example.gestion_scolaire.service.ClasseService;
import com.example.gestion_scolaire.service.EnseignantService;
import com.example.gestion_scolaire.service.EtudiantService;
import com.example.gestion_scolaire.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class GestionStagiaireApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionStagiaireApplication.class, args);
    }

    @Bean
        //au démarrage crée moi un PasswordEncoder et tu le place dans context
    BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner commandLineRunner(EtudiantService etudiantService,
                                        EnseignantService enseignantService,
                                        ClasseService classeService){
        return args -> {
            EnseignantDto saveEnseignantDto = enseignantService.save(EnseignantDto.fromEntity(new Enseignant(null, "med", "BOUGANFOU")));
            ClasseDto classeDto1 = classeService.save(ClasseDto.fromEntity(new Classe(null, "classe1", EnseignantDto.toEntity(saveEnseignantDto))));
            etudiantService.save(EtudiantDto.fromEntity(new Etudiant(null,"lhoussaine","BOUGANFOU",ClasseDto.toEntity(classeDto1))));
            etudiantService.save(EtudiantDto.fromEntity(new Etudiant(null,"lhss","OUHAMZA",ClasseDto.toEntity(classeDto1))));
            etudiantService.save(EtudiantDto.fromEntity(new Etudiant(null,"adil","TAGGUINE",ClasseDto.toEntity(classeDto1))));

            etudiantService.findAll(PageRequest.of(0, 5)).forEach(p->{
                System.out.println(p.getNom());
            });

        };
    }
    @Bean
    CommandLineRunner saveUsers(SecurityService securityService){
        return args ->{
            securityService.saveNewUser("lhss","1234","1234");
            securityService.saveNewUser("adil","1234","1234");
            securityService.saveNewUser("lhoussaine","1234","1234");

            securityService.saveNewRole("USER","");
            securityService.saveNewRole("ADMIN","");

            securityService.addRoleToUser("lhss","USER");
            securityService.addRoleToUser("adil","ADMIN");
            securityService.addRoleToUser("lhoussaine","USER");


        };
    }
}
