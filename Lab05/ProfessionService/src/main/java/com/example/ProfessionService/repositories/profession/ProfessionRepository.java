package com.example.ProfessionService.repositories.profession;

import com.example.ProfessionService.entity.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfessionRepository extends JpaRepository<Profession, UUID> {
    List<Profession> findAll();
    List<Profession> findByNameIgnoreCase(String name);
    Optional<Profession> findById(UUID id);
}
