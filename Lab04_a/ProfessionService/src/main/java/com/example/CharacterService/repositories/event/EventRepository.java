package com.example.CharacterService.repositories.event;

import java.util.UUID;

public interface EventRepository {
    void sendCreateProfessionEvent(UUID categoryId);

    void sendDeleteProfessionEvent(UUID categoryId);
}
