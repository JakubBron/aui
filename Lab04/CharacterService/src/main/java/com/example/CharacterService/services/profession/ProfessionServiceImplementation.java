package com.example.CharacterService.services.profession;

import com.example.CharacterService.entities.Profession;
import com.example.CharacterService.repositories.ProfessionRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Transactional
@Service
public class ProfessionServiceImplementation implements ProfessionService {
    private final ProfessionRepository professionRepository;

    @Autowired
    public ProfessionServiceImplementation(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }

    @Override
    public List<Profession> findAll() {
        return professionRepository.findAll();
    }

    @Override
    public Optional<Profession> findById(UUID id) {
        return professionRepository.findById(id);
    }

    @Override
    public void create(Profession profession) {
        professionRepository.save(profession);
    }

    @Override
    public void update(Profession profession) {
        professionRepository.save(profession);
    }

    @Override
    public void delete(UUID id) {
        professionRepository.deleteById(id);
    }


}
