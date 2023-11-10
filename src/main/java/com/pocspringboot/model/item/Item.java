package com.pocspringboot.model.item;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class Item {

    private String name;

    private String value;

    private Float weight;

    private String image;

}
