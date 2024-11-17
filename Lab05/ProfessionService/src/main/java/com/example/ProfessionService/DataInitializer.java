package com.example.ProfessionService;

import com.example.ProfessionService.entity.Profession;
import com.example.ProfessionService.repositories.profession.ProfessionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class DataInitializer {
    private final ProfessionRepository cr;
    private Random random = new Random(2137);

    @Autowired
    public DataInitializer(ProfessionRepository categoryRepository) {
        this.cr = categoryRepository;
    }

    @PostConstruct
    public void createAndLoadData() {
        if(!cr.findAll().isEmpty()) {
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
        }
        cr.saveAll(professions);

    }
}
