package com.pocspringboot.strategy.impl;

import com.pocspringboot.enumeration.ItemType;
import com.pocspringboot.model.domain.items.Armor;
import com.pocspringboot.model.request.ItemRequest;
import com.pocspringboot.strategy.ItemStrategy;

public class ArmorFactory implements ItemStrategy {

    @Override
    public ItemType getItemType() {
        return ItemType.ARMOR;
    }

    @Override
    public Armor createItem(ItemRequest itemRequest) {
        return Armor.builder()
                .name(itemRequest.getName())
                .value(itemRequest.getValue())
                .weight(itemRequest.getWeight())
                .image(itemRequest.getImage())
                .description(itemRequest.getDescription())
                .rarity(itemRequest.getRarity())
                .defense(itemRequest.getDefense())
                .build();
    }

    @Override
    public String returnSomethingCool(ItemRequest itemRequest) {
        return "THIS IS AN ARMOR FACTORY!";
    }

}
