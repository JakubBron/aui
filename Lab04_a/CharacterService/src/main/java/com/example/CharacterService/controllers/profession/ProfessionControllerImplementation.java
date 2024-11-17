package com.example.CharacterService.controllers.profession;

import com.example.ProfessionService.entity.Category;
import com.example.ProfessionService.service.category.CategoryService;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class ProfessionControllerImplementation implements ProfessionController {

    private final ProfessionService professionService;


    public ProfessionControllerImplementation(ProfessionService professionService) {
        this.professionService = professionService;
    }

    @Override
    public void createProfession(UUID uuid) {
        if(uuid == null)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "UUID nie może być puste!");
        }

        if(professionService.findById(uuid).isPresent())
        {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Profesja już istnieje!");
        }

        professionService.create(Profession.builder().id(uuid).build());
    }

    @Override
    public void deleteProfession(UUID uuid) {
        if(professionService.findById(uuid).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesja nie istnieje!");
        }

        professionService.delete(uuid);
    }
}
