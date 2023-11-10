package com.pocspringboot.batch.character;

import org.springframework.batch.item.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Iterator;

@Component
public class CharacterReader implements ItemReader<String> {

    private final Iterator<String> dataIterator;

    public CharacterReader() {
        this.dataIterator = Arrays.asList("item1", "item2", "item3", "item1",
                "item2", "item3", "item1", "item2", "item3", "item1", "item2", "item3", "item1", "item2", "item3").iterator();
    }

    @Override
    public String read() throws Exception {
        return dataIterator.hasNext() ? dataIterator.next() : null;
    }
}
