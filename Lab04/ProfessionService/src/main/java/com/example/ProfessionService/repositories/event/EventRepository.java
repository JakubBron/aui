package com.example.ProfessionService.repositories.event;

import java.util.UUID;

public interface EventRepository {
    void sendCreateProfessionEvent(UUID categoryId);

    void sendDeleteProfessionEvent(UUID categoryId);
}
