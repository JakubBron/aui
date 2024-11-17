package com.example.CharacterService.controllers.profession;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;
public interface ProfessionController {

    @PutMapping("/professions/{uuid}") // PUT here, not POST because if does exist, updates it and all info about it
    @ResponseStatus(HttpStatus.CREATED)
    void createProfession(@PathVariable UUID uuid);

    @DeleteMapping("/professions/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProfession(@PathVariable UUID uuid);
}
