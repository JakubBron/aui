package com.example.controllers.character.mapper;


import org.springframework.stereotype.Component;
import java.util.function.Function;
import com.example.entities.Character;
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