package com.example.controllers.character.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateCharacterRequest {
    String name;
    Integer age;
    Integer level;
}