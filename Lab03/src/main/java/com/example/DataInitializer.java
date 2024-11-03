package com.example;

import com.example.entities.Profession;
import com.example.entities.Character;
import com.example.services.character.CharacterService;
import com.example.services.profession.ProfessionService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Component
public class DataInitializer {
    private final CharacterService cs;
    private final ProfessionService ps;
    private Random random = new Random();

    @Autowired
    public DataInitializer(CharacterService characterService, ProfessionService professionService) {
        this.cs = characterService;
        this.ps = professionService;
    }

    @PostConstruct
    public void createAndLoadData() {
        if(!cs.findAll().isEmpty() || !ps.findAll().isEmpty()) {
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

        List<String> characterNames = List.of("Jan", "Paweł", "Grzegorz", "Kazimierz");
        for(int i = 0; i < characterNames.size(); i++) {
            //Character character = Character.autoBuilder()
            Character character = Character.builder()
                    .id(UUID.nameUUIDFromBytes(characterNames.get(i).getBytes()))
                    .name(characterNames.get(i))
                    .age(random.nextInt(18, 40))
                    .level(random.nextInt(4, 10))
                    .profession(professions.get(i % professionNames.size()))
                    .build();
            cs.create(character);
        }
    }
}
