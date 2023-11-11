package com.pocspringboot.batch.character.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CharacterDto {

    private String name;

    private String age;

    private String race;

    private String gender;

}
