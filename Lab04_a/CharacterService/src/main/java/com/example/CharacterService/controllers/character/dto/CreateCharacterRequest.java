package com.example.CharacterService.controllers.character.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateCharacterRequest {
    String name;
    int age;
    int level;
}