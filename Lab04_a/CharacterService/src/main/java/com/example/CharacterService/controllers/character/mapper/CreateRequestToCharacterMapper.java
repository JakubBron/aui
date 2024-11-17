package com.example.CharacterService.controllers.character.mapper;


import com.example.CharacterService.entities.Character;
import org.springframework.stereotype.Component;
import java.util.function.Function;

import com.example.controllers.character.dto.CreateCharacterRequest;

@Component
public class CreateRequestToCharacterMapper implements Function<CreateCharacterRequest, Character> {
    @Override
    public Character apply(CreateCharacterRequest createCharacterRequest) {
        return Character.builder()
                .name(createCharacterRequest.getName())
                .age(createCharacterRequest.getAge())
                .level(createCharacterRequest.getLevel())
                .build();
    }
}