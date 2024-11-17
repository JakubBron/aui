package com.example.CharacterService.controllers.character;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.CharacterService.controllers.character.dto.*;



import java.util.UUID;
public interface CharacterController {
    @GetMapping("/characters")
    @ResponseStatus(HttpStatus.OK)
    CharactersResponse getCharacters();

    @GetMapping("/characters/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    CharacterResponse getCharacter(@PathVariable UUID uuid);

    @GetMapping("/professions/{uuid}/characters")
    @ResponseStatus(HttpStatus.OK)
    CharactersResponse getCharactersByProfession(@PathVariable UUID uuid);

    @PostMapping("/professions/{uuid}/characters") // POST here, because we only need to create a new object
    @ResponseStatus(HttpStatus.CREATED)
    CharacterResponse createCharacter(@PathVariable UUID uuid, @RequestBody CreateCharacterRequest request);

    @PatchMapping("/characters/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    CharacterResponse updateCharacter(@PathVariable UUID uuid, @RequestBody UpdateCharacterRequest request);

    @DeleteMapping("/characters/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteCharacter(@PathVariable UUID uuid);
}