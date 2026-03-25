package com.bnpe.demo.config;

import com.bnpe.demo.model.Agence;
import com.bnpe.demo.model.RoleType;
import com.bnpe.demo.model.User;
import com.bnpe.demo.repository.AgenceRepository;
import com.bnpe.demo.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(AgenceRepository agenceRepository, UserRepository userRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) {
                if (agenceRepository.count() == 0) {
                    Agence siege = new Agence();
                    siege.setCode("AG-SIEGE");
                    siege.setNom("Agence Siège");
                    siege.setVille("Libreville");
                    siege.setActif(true);
                    agenceRepository.save(siege);

                    Agence owendo = new Agence();
                    owendo.setCode("AG-OWE");
                    owendo.setNom("Agence Owendo");
                    owendo.setVille("Owendo");
                    owendo.setActif(true);
                    agenceRepository.save(owendo);
                }

                if (userRepository.count() == 0) {
                    Agence siege = agenceRepository.findByCode("AG-SIEGE").orElse(null);

                    User dg = new User();
                    dg.setNomComplet("Directeur Général Démo");
                    dg.setEmail("dg@bnpe.demo");
                    dg.setPassword("1234");
                    dg.setRole(RoleType.DG);
                    dg.setAgence(siege);
                    dg.setActif(true);
                    userRepository.save(dg);

                    User chef = new User();
                    chef.setNomComplet("Chef de Service Démo");
                    chef.setEmail("chef@bnpe.demo");
                    chef.setPassword("1234");
                    chef.setRole(RoleType.CHEF_SERVICE);
                    chef.setAgence(siege);
                    chef.setActif(true);
                    userRepository.save(chef);
                }
            }
        };
    }
}
