package com.pocspringboot.batch.character;

import com.pocspringboot.batch.character.dto.CharacterDto;
import com.pocspringboot.model.domain.CharacterDomain;
import com.pocspringboot.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class CharacterWriter implements ItemWriter<CharacterDto> {

    private final CharacterRepository characterRepository;

    @Override
    public void write(List<? extends CharacterDto> characterDtos) throws Exception {
        List<CharacterDomain> characterDomains = characterDtos.stream()
                .map(CharacterDomain::valueOf)
                .collect(Collectors.toList());

        characterRepository.saveAll(characterDomains);
    }

}
