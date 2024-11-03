package com.example.controllers.profession.dto;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;

@Value
@Builder
public class ProfessionResponse {
    UUID id;
    String name;
    int yearsOfExperience;
}
