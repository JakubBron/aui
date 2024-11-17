package com.example.ProfessionService.repositories.event;

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
    public void sendCreateProfessionEvent(UUID professionId) {
        characterServiceRestTemplate.put("/professions/" + professionId, null);
    }

    @Override
    public void sendDeleteProfessionEvent(UUID professionId) {
        characterServiceRestTemplate.delete("/professions/" + professionId);
    }
}
