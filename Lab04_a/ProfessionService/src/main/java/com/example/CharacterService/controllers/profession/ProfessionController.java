package com.example.CharacterService.controllers.profession;

import com.example.CharacterService.controllers.profession.dto.CreateProfessionRequest;
import com.example.CharacterService.controllers.profession.dto.ProfessionsResponse;
import com.example.CharacterService.controllers.profession.dto.UpdateProfessionRequest;
import com.example.CharacterService.controllers.profession.dto.ProfessionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
public interface ProfessionController {
    @GetMapping("/professions")
    @ResponseStatus(HttpStatus.OK)
    ProfessionsResponse getProfessions();

    @GetMapping("/professions/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    ProfessionResponse getProfession(@PathVariable UUID uuid);

    @PutMapping("/professions") // PUT here, not POST because if does exist, updates it and all info about it
    @ResponseStatus(HttpStatus.CREATED)
    ProfessionResponse createProfession(@RequestBody CreateProfessionRequest request);

    @PatchMapping("/professions/{uuid}")    // PATCH here, not PUT because it demands that object exists (in content just new values, just a delta of the info stored here)
    @ResponseStatus(HttpStatus.OK)
    ProfessionResponse updateProfession(@PathVariable UUID uuid, @RequestBody UpdateProfessionRequest request);

    @DeleteMapping("/professions/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteProfession(@PathVariable UUID uuid);
}
