package com.example.controllers.profession.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UpdateProfessionRequest {
    String name;
    Integer yearsOfExperience;
}
