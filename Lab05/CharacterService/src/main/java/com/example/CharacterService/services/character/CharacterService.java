package com.example.CharacterService.services.character;

import com.example.CharacterService.entities.Character;
import com.example.CharacterService.entities.Profession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CharacterService {
    List<Character> findAll();
    Optional<Character> findById(UUID id);
    List<Character> findByProfession(Profession profession);
    List<Character> findByLevel(int level);
    List<Character> findByAge(int age);
    List<Character> findByNameIgnoreCase(String name);

    void create(Character character);
    void update(Character character);
    void delete(UUID characterId);
}
