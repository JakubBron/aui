package com.example.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.entities.Profession;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProfessionRepository extends JpaRepository<Profession, UUID> {
    List<Profession> findAll();
    List<Profession> findByNameIgnoreCase(String name);

    Optional<Profession> findById(UUID id);
}
