package com.example.CharacterService.controllers.character.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class CharacterResponse {
    UUID id;
    String name;
    int age;
    int level;
    Profession profession;

    @Value
    @Builder
    public static class Profession {
        UUID id;
        String name;
    }
}