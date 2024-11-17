package com.example.ProfessionService.controllers.profession;

import com.example.ProfessionService.controllers.profession.dto.CreateProfessionRequest;
import com.example.ProfessionService.controllers.profession.dto.ProfessionResponse;
import com.example.ProfessionService.controllers.profession.dto.ProfessionsResponse;
import com.example.ProfessionService.controllers.profession.dto.UpdateProfessionRequest;
import com.example.ProfessionService.controllers.profession.mapper.CreateRequestToProfessionMapper;
import com.example.ProfessionService.controllers.profession.mapper.ProfessionsToResponseMapper;
import com.example.ProfessionService.controllers.profession.mapper.ProfessionToResponseMapper;
import com.example.ProfessionService.service.profession.ProfessionService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
@RestController
public class ProfessionControllerImplementation implements ProfessionController {

    private final ProfessionService professionService;

    private final ProfessionToResponseMapper professionToResponseMapper;
    private final ProfessionsToResponseMapper professionsToResponseMapper;
    private final CreateRequestToProfessionMapper createRequestToProfessionMapper;

    public ProfessionControllerImplementation(ProfessionService professionService,
            ProfessionToResponseMapper professionToResponseMapper,
            ProfessionsToResponseMapper professionsToResponseMapper,
            CreateRequestToProfessionMapper createRequestToProfessionMapper) {

        this.professionService = professionService;
        this.professionToResponseMapper = professionToResponseMapper;
        this.professionsToResponseMapper = professionsToResponseMapper;
        this.createRequestToProfessionMapper = createRequestToProfessionMapper;
    }

    @Override
    public ProfessionsResponse getProfessions() {
        return professionsToResponseMapper.apply(professionService.findAll());
    }

    @Override
    public ProfessionResponse getProfession(UUID uuid) {
        return professionService.findById(uuid)
                .map(professionToResponseMapper)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesja nie istnieje!"));
    }

    @Override
    public ProfessionResponse createProfession(CreateProfessionRequest request) {
        if(request.getName() == null || request.getName().isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nazwa profesji nie może być pusta!");
        }

        if(request.getYearsOfExperience() <= 0)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lata doświadczenia nie mogą być ujemne!");
        }

        var profession = createRequestToProfessionMapper.apply(request);
        professionService.create(profession);

        return professionToResponseMapper.apply(profession);
    }

    @Override
    public ProfessionResponse updateProfession(UUID uuid, UpdateProfessionRequest request) {
        var profession = professionService.findById(uuid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesja nie istnieje!"));

        if(request.getName() == null || request.getName().isEmpty())
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Nazwa profesji nie może być pusta!");
        }
        if(request.getYearsOfExperience() <= 0)
        {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Lata doświadczenia nie mogą być ujemne!");
        }

        profession.setName(request.getName());
        profession.setYearsOfExperience(request.getYearsOfExperience());

        professionService.update(profession);

        return professionToResponseMapper.apply(profession);
    }

    @Override
    public void deleteProfession(UUID uuid) {
        if(professionService.findById(uuid).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Profesja nie istnieje!");
        }

        professionService.delete(uuid);
    }
}