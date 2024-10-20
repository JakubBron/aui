package com.example.services.character;

import com.example.repositories.CharacterRepository;
import com.example.entities.Character;
import com.example.entities.Profession;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional // When using database
@Service
public class CharacterServiceImplementation implements CharacterService{

    private final CharacterRepository characterRepository;

    @Autowired // Dependency injection
    // dependency injection - in this class I want to use instance of another class.
    // I can pass it as a parameter in constructor or
    // using a setter or
    // using @Autowired annotation - when building, it will detect new object is needed and will create it.
    public CharacterServiceImplementation(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Optional<Character> findById(UUID id) {
        return characterRepository.findById(id);
    }

    @Override
    public List<Character> findByProfession(Profession profession) {
        return characterRepository.findByProfession(profession);
    }

    @Override
    public List<Character> findByLevel(int level) {
        return characterRepository.findByLevel(level);
    }

    @Override
    public List<Character> findByAge(int age) {
        return characterRepository.findByAge(age);
    }

    @Override
    public List<Character> findByNameIgnoreCase(String name) {
        return characterRepository.findByNameIgnoreCase(name);
    }

    @Override
    public void create(Character character) {
        characterRepository.save(character);
    }

    @Override
    public void update(Character character) {
        characterRepository.save(character);
    }

    @Override
    public void delete(UUID characterId) {
        characterRepository.deleteById(characterId);
    }

}
