package com.pocspringboot.batch.character;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CharacterProcessor implements ItemProcessor<String, String> {

    @Override
    public String process(String string) throws Exception {
        return string + "_p";
    }
}
