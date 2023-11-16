package com.pocspringboot.controller;

import com.pocspringboot.model.request.CreateCharacterBatchRequest;
import com.pocspringboot.model.request.CreateCharacterRequest;
import com.pocspringboot.model.request.TrainingNumberReverseRequest;
import com.pocspringboot.model.response.CharacterResponse;
import com.pocspringboot.service.CharacterService;
import com.pocspringboot.service.TrainingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
public class CharacterController {

    private final CharacterService characterService;

    @PostMapping("/characters")
    public void createCharacter(@RequestBody CreateCharacterRequest createCharacterRequest) {
        characterService.createCharacter(createCharacterRequest);
    }

    @PostMapping("/characters/batch")
    public void createCharacterBatch(@RequestBody CreateCharacterBatchRequest request) {
        characterService.createCharacterBatch(request);
    }

    @GetMapping("/characters")
    public List<CharacterResponse> getCharacters() {
        return characterService.getCharacters();
    }

    @GetMapping("/characters/{id}")
    public CharacterResponse getCharacterById(@PathVariable Long id) {
        return characterService.getCharacterById(id);
    }

}
