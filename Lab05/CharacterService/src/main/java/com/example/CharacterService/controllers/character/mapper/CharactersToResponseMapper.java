package com.example.CharacterService.controllers.character.mapper;

import com.example.CharacterService.entities.Character;
import com.example.CharacterService.controllers.character.dto.CharactersResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Function;

@Component
public class CharactersToResponseMapper implements Function<List<Character>, CharactersResponse> {

    public CharactersResponse apply(List<Character> characters) {
        return CharactersResponse.builder()
                .characters(characters.stream()
                        .map(character ->
                            CharactersResponse.Character.builder()
                                    .id(character.getId())
                                    .name(character.getName())
                                    .build())
                        .toList()
                ).build();
    }
}
