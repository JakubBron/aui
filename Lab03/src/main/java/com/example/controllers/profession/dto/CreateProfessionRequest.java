package com.example.controllers.profession.dto;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CreateCategoryRequest {
    String name;
    int yearsOfExperience;
}
