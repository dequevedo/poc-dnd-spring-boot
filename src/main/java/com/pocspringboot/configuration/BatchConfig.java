package com.pocspringboot.configuration;

import com.pocspringboot.batch.character.CharacterReader;
import com.pocspringboot.batch.character.dto.CharacterDto;
import lombok.AllArgsConstructor;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.IntStream;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
public class BatchConfig {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    @StepScope
    public CharacterReader characterReader() {
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer(",");
        String[] fields = Arrays.stream(CharacterDto.class.getDeclaredFields()).map(Field::getName).toArray(String[]::new);

        int[] ints = IntStream.range(0, fields.length).toArray();

        lineTokenizer.setNames(fields);
        lineTokenizer.setIncludedFields(ints);

        BeanWrapperFieldSetMapper<CharacterDto> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(CharacterDto.class);

        DefaultLineMapper<CharacterDto> lineMapper = new DefaultLineMapper<>();
        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);

        CharacterReader reader = new CharacterReader();
        reader.setResource(new ClassPathResource("scripts/characters.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper);

        return reader;
    }


}
