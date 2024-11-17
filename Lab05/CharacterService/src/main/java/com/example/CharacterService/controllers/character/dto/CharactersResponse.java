package com.example.CharacterService.controllers.character.dto;

import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.UUID;

@Value
@Builder
public class CharactersResponse {
    List<Character> characters;

    @Value
    @Builder
    public static class Character {
        UUID id;
        String name;
    }
}