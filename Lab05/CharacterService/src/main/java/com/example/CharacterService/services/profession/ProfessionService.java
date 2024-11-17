package com.example.CharacterService.services.profession;

import com.example.CharacterService.entities.Profession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfessionService {
    List<Profession> findAll();
    Optional<Profession> findById(UUID id);
    void create(Profession profession);
    void update(Profession profession);
    void delete(UUID id);
}
