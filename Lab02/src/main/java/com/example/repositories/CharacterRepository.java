package com.example.repositories;

import jdk.jfr.Category;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.example.entities.Character;
import com.example.entities.Profession;

@Repository
public interface CharacterRepository extends JpaRepository<Character, UUID> {
    // Why interface? Because we are using Spring Data JPA (via @Repository),
    // which provides derived operations: https://www.baeldung.com/spring-data-derived-queries.
    List<Character> findAll();
    Optional<Character> findById(UUID id);
    List<Character> findByProfession(Profession profession);
    List<Character> findByLevel(int level);
    List<Character> findByAge(int age);
    List<Character> findByNameIgnoreCase(String name);
}
