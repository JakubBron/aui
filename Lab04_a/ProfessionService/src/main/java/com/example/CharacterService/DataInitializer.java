package com.example.CharacterService;

import com.example.CharacterService.entities.Profession;
import com.example.CharacterService.services.profession.ProfessionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class DataInitializer {
    private final ProfessionService ps;
    private Random random = new Random();

    @Autowired
    public DataInitializer(ProfessionService professionService) {
        this.ps = professionService;
    }

    @PostConstruct
    public void createAndLoadData() {
        if(!ps.findAll().isEmpty()) {
            return; // something already exists, no need to initialize
        }

        List<Profession> professions = new ArrayList<>();
        List<String> professionNames = List.of("Żołnierz", "Aktor", "Złodziej");
        for(int i = 0; i < professionNames.size(); i++) {
            Profession profession = Profession.builder()
                    .id(UUID.nameUUIDFromBytes(professionNames.get(i).getBytes()))
                    .name(professionNames.get(i))
                    .yearsOfExperience(random.nextInt(1, 12))
                    .build();
            professions.add(profession);
            ps.create(profession);
        }

    }
}
