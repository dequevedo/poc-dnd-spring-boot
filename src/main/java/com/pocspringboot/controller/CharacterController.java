package com.pocspringboot.controller;

import com.pocspringboot.model.request.CreateCharacterRequest;
import com.pocspringboot.model.response.CharacterResponse;
import com.pocspringboot.service.CharacterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class CharacterController {

    private final CharacterService characterService;

    @PostMapping("/character")
    public void createCharacter(@RequestBody CreateCharacterRequest createCharacterRequest) {
        characterService.createCharacter(createCharacterRequest);
    }

    @GetMapping("/character")
    public List<CharacterResponse> getCharacters() {
        return characterService.getCharacters();
    }

}
