package com.pocspringboot.strategy.impl;

import com.pocspringboot.enumeration.ItemType;
import com.pocspringboot.model.domain.items.Weapon;
import com.pocspringboot.model.request.ItemRequest;
import com.pocspringboot.strategy.ItemStrategy;

public class WeaponFactory implements ItemStrategy {

    @Override
    public ItemType getItemType() {
        return ItemType.WEAPON;
    }

    @Override
    public Weapon createItem(ItemRequest itemRequest) {
        return Weapon.builder()
                .name(itemRequest.getName())
                .value(itemRequest.getValue())
                .weight(itemRequest.getWeight())
                .image(itemRequest.getImage())
                .description(itemRequest.getDescription())
                .rarity(itemRequest.getRarity())
                .damage(itemRequest.getDamage())
                .build();
    }

    @Override
    public String returnSomethingCool(ItemRequest itemRequest) {
        return "THIS IS AN WEAPON FACTORY!";
    }

}
