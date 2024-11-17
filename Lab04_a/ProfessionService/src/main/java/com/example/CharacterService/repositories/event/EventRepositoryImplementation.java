package com.example.CharacterService.repositories.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Repository
public class EventRepositoryImplementation implements EventRepository {

    @Qualifier("character-service")
    private final RestTemplate characterServiceRestTemplate;

    @Autowired
    public EventRepositoryImplementation(RestTemplate characterServiceRestTemplate) {
        this.characterServiceRestTemplate = characterServiceRestTemplate;
    }

    @Override
    public void sendCreateProfessionEvent(UUID categoryId) {
        characterServiceRestTemplate.put("/professions" + categoryId, null);
    }

    @Override
    public void sendDeleteProfessionEvent(UUID categoryId) {
        characterServiceRestTemplate.delete("/professions" + categoryId);
    }
}
