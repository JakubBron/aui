package com.example.CharacterService.controllers.profession.mapper;

import com.example.CharacterService.controllers.profession.dto.CreateProfessionRequest;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import com.example.CharacterService.entities.Profession;

@Component
public class CreateRequestToProfessionMapper implements Function<CreateProfessionRequest, Profession> {
    @Override
    public Profession apply(CreateProfessionRequest createProfessionRequest) {
        return Profession.builder()
                .name(createProfessionRequest.getName())
                .yearsOfExperience(createProfessionRequest.getYearsOfExperience())
                .build();
    }
}