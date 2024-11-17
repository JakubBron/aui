package com.example.CharacterService.controllers.profession.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateProfessionRequest {
    String name;
    int yearsOfExperience;
}
