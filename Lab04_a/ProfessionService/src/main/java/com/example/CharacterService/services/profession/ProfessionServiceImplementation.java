package com.example.CharacterService.services.profession;

import com.example.CharacterService.entities.Profession;
import com.example.CharacterService.repositories.event.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.CharacterService.repositories.profession.ProfessionRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Transactional
@Service
public class ProfessionServiceImplementation implements ProfessionService {
    private final ProfessionRepository professionRepository;
    private final EventRepository eventRepository;

    @Autowired
    public ProfessionServiceImplementation(ProfessionRepository professionRepository, EventRepository eventRepository) {
        this.professionRepository = professionRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Profession> findAll() {
        return professionRepository.findAll();
    }

    @Override
    public List<Profession> findByNameIgnoreCase(String name) {
        return professionRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Optional<Profession> findById(UUID id) {
        return professionRepository.findById(id);
    }

    @Override
    public void create(Profession profession) {
        professionRepository.save(profession);
        eventRepository.sendCreateProfessionEvent(profession.getId());
    }

    @Override
    public void update(Profession profession) {
        professionRepository.save(profession);
    }

    @Override
    public void delete(UUID id) {
        professionRepository.deleteById(id);
        eventRepository.sendDeleteProfessionEvent(id);
    }


}
