package com.example.controllers.character.mapper;

import org.springframework.stereotype.Component;
import java.util.function.Function;

import com.example.entities.Character;
import com.example.controllers.character.dto.CharacterResponse;
@Component
public class CharacterToResponseMapper implements Function<Character, CharacterResponse> {
    @Override
    public CharacterResponse apply(Character character) {
        return CharacterResponse.builder()
                .id(character.getId())
                .name(character.getName())
                .age(character.getAge())
                .level(character.getLevel())
                .profession(CharacterResponse.Profession.builder()
                            .id(character.getProfession().getId())
                            .name(character.getProfession().getName())
                            .build()
                )
                .build();
    }
}
