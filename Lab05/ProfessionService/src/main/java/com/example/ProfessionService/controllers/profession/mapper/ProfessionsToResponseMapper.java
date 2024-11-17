package com.example.ProfessionService.controllers.profession.mapper;

import com.example.ProfessionService.controllers.profession.dto.ProfessionsResponse;
import com.example.ProfessionService.entity.Profession;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;
@Component
public class ProfessionsToResponseMapper implements Function<List<Profession>, ProfessionsResponse>{
    @Override
    public ProfessionsResponse apply(List<Profession> professions) {
        return ProfessionsResponse.builder()
                .professions(professions.stream()
                        .map(profession -> ProfessionsResponse.Profession.builder()
                                .id(profession.getId())
                                .name(profession.getName())
                                .build())
                        .toList())
                .build();
    }
}