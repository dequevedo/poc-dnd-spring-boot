package com.pocspringboot.batch.character;

import com.pocspringboot.batch.character.dto.CharacterDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileParseException;

@Slf4j
public class CharacterReader extends FlatFileItemReader<CharacterDto> {

    @Override
    public CharacterDto doRead() throws Exception {
        try {
            return super.doRead();
        } catch (FlatFileParseException e) {
            log.error("Error parsing line {}. Invalid layout: {}", e.getLineNumber(), e.getInput());
            throw e;
        }
    }

}
