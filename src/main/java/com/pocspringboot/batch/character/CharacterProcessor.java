package com.pocspringboot.batch.character;

import com.pocspringboot.batch.character.dto.CharacterDto;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CharacterProcessor implements ItemProcessor<CharacterDto, CharacterDto> {

    @Override
    public CharacterDto process(CharacterDto characterDto) throws Exception {
        characterDto.setName(characterDto.getName() + "_processed");
        return characterDto;
    }

}
