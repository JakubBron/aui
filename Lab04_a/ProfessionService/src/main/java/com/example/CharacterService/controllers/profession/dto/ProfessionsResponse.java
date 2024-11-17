package com.example.CharacterService.controllers.profession.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class ProfessionsResponse {
    List<Profession> professions;

    @Value
    @Builder
    public static class Profession {
        UUID id;
        String name;
    }
}