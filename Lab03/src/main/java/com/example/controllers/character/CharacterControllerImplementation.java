package com.example.controllers.character;

import com.example.controllers.character.dto.CharacterResponse;
import com.example.controllers.character.dto.CreateCharacterRequest;
import com.example.controllers.character.dto.UpdateCharacterRequest;
import com.example.controllers.character.mapper.CharacterToResponseMapper;
import com.example.controllers.character.mapper.CharactersToResponseMapper;
import com.example.controllers.character.mapper.CreateRequestToCharacterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.controllers.character.dto.CharactersResponse;
import com.example.services.character.CharacterService;
import com.example.services.profession.ProfessionService;

import java.util.UUID;
import lombok.extern.java.Log;
import org.springframework.web.server.ResponseStatusException;

@RestController
@Log
public class CharacterControllerImplementation implements CharacterController {
    private final CharacterService characterService;
    private final ProfessionService professionService;

    private final CharacterToResponseMapper characterToResponseMapper;
    private final CharactersToResponseMapper charactersToResponseMapper;
    private final CreateRequestToCharacterMapper createRequestToCharacterMapper;

    @Autowired
    public CharacterControllerImplementation(CharacterService characterService,
                                           ProfessionService professionService,
                                 CharacterToResponseMapper characterToResponseMapper,
                                 CharactersToResponseMapper charactersToResponseMapper,
                                 CreateRequestToCharacterMapper createRequestToCharacterMapper) {
        this.characterService = characterService;
        this.professionService = professionService;
        this.characterToResponseMapper = characterToResponseMapper;
        this.charactersToResponseMapper = charactersToResponseMapper;
        this.createRequestToCharacterMapper = createRequestToCharacterMapper;
    }
    @Override
    public CharactersResponse getCharacters() {
        return charactersToResponseMapper.apply(characterService.findAll());
    }
    @Override
    public CharacterResponse getCharacter(UUID uuid) {
        return characterService.findById(uuid)
                .map(characterToResponseMapper)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Postać nie istnieje"));
    }

    @Override
    public CharactersResponse getCharactersByProfession(UUID uuid) {
        var profession = professionService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesja nie istnieje"));

        return charactersToResponseMapper.apply(characterService.findByProfession(profession));
    }

    @Override
    public CharacterResponse createCharacter(UUID uuid, CreateCharacterRequest request) {

        if (request.getName() == null || request.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Imię jest wymagane!");
        }
        if (request.getAge() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wiek musi być >= 0!");
        }
        if (request.getLevel() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Level musi być >= 0!");
        }

        var profession = professionService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nieznana profesja!"));

        var character = createRequestToCharacterMapper.apply(request);
        character.setProfession(profession);
        characterService.create(character);

        return characterToResponseMapper.apply(character);
    }

    @Override
    public CharacterResponse updateCharacter(UUID uuid, UpdateCharacterRequest request) {
        var character = characterService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Postać nie istnieje!"));

        if (request.getName() != null) {
            character.setName(request.getName());
        }
        if (request.getAge() != null) {
            if (request.getAge() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Wiek musi być >= 0!");
            }
            character.setAge(request.getAge());
        }
        if (request.getLevel() != null) {
            if (request.getLevel() < 0) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Level musi być >= 0!");
            }
            character.setLevel(request.getLevel());
        }

        characterService.update(character);

        return characterToResponseMapper.apply(character);
    }

    @Override
    public void deleteCharacter(UUID uuid) {
        if (characterService.findById(uuid).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Postać nie istnieje!");
        }

        characterService.delete(uuid);
    }
}
