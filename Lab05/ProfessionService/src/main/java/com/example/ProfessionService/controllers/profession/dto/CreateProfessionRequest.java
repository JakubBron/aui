package com.example.ProfessionService.controllers.profession.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateProfessionRequest {
    String name;
    int yearsOfExperience;
}