package com.example.CharacterService.controllers.profession.mapper;

import com.example.CharacterService.controllers.profession.dto.ProfessionResponse;
import com.example.CharacterService.entities.Profession;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProfessionToResponseMapper implements Function<Profession, ProfessionResponse>{
    @Override
    public ProfessionResponse apply(Profession profession) {
        return ProfessionResponse.builder()
                .id(profession.getId())
                .name(profession.getName())
                .yearsOfExperience(profession.getYearsOfExperience())
                .build();
    }
}
