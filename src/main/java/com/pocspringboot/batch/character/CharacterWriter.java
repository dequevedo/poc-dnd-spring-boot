package com.pocspringboot.batch.character;

import com.pocspringboot.batch.character.dto.CharacterDto;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CharacterWriter implements ItemWriter<CharacterDto> {

    @Override
    public void write(List<? extends CharacterDto> list) throws Exception {
        for (CharacterDto character : list) {
            System.out.println(character);
        }
    }

}
