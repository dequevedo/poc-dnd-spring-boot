package com.pocspringboot.service;

import com.pocspringboot.model.domain.CharacterDomain;
import com.pocspringboot.model.request.CreateCharacterBatchRequest;
import com.pocspringboot.model.request.CreateCharacterRequest;
import com.pocspringboot.model.response.CharacterResponse;
import com.pocspringboot.repository.CharacterRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class CharacterService {

    private final CharacterRepository characterRepository;

    private final JobLauncher jobLauncher;

    @Qualifier("characterJob")
    private final Job job;

    public void createCharacter(CreateCharacterRequest createCharacterRequest) {
        CharacterDomain characterDomain = CharacterDomain.valueOf(createCharacterRequest);
        characterRepository.save(characterDomain);
    }

    public void createCharacterBatch(CreateCharacterBatchRequest request) {
        startCreateCharacterBatch();
    }

    public List<CharacterResponse> getCharacters() {
        return characterRepository.findAll().stream().map(CharacterResponse::valueOf).toList();
    }

    //TODO add sneakythrows?
    private void startCreateCharacterBatch() {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(job, jobParameters);
        } catch (Exception e) {
            log.info("Falha ao iniciar o job: " + e.getMessage());
        }
    }

}
