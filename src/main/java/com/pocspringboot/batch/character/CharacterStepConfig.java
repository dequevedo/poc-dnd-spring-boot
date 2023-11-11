package com.pocspringboot.batch.character;

import com.pocspringboot.batch.character.dto.CharacterDto;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class CharacterStepConfig {

    public final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step characterStep(CharacterReader reader, CharacterProcessor processor, CharacterWriter writer) {
        return stepBuilderFactory.get("characterStep")
                .<CharacterDto, CharacterDto>chunk(10)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

}
