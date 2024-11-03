package com.example.controllers.character.mapper;

import com.example.controllers.character.dto.CharactersResponse;
import com.example.entities.Character;
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
