package com.pocspringboot.service;

import com.pocspringboot.model.domain.CharacterDomain;
import com.pocspringboot.model.request.CreateCharacterRequest;
import com.pocspringboot.model.response.CharacterResponse;
import com.pocspringboot.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    public void createCharacter(CreateCharacterRequest createCharacterRequest) {
        CharacterDomain characterDomain = CharacterDomain.valueOf(createCharacterRequest);
        characterRepository.save(characterDomain);
    }

    public List<CharacterResponse> getCharacters() {
        return characterRepository.findAll().stream().map(CharacterResponse::valueOf).toList();
    }

}
