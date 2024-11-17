package com.example.ProfessionService.service.profession;

import com.example.ProfessionService.entity.Profession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfessionService {
    List<Profession> findAll();
    List<Profession> findByNameIgnoreCase(String name);
    Optional<Profession> findById(UUID id);
    void create(Profession profession);
    void update(Profession profession);
    void delete(UUID id);
}
