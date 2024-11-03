package com.example.controllers.profession.mapper;

import com.example.controllers.profession.dto.CreateProfessionRequest;
import jdk.jfr.Category;
import org.springframework.stereotype.Component;

import java.util.function.Function;
import com.example.entities.Profession;
import com.example.controllers.profession.dto.CreateProfessionRequest;

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
