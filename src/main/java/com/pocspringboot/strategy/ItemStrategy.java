package com.pocspringboot.strategy;

import com.pocspringboot.enumeration.ItemType;
import com.pocspringboot.model.domain.items.ItemDomain;
import com.pocspringboot.model.request.ItemRequest;

public interface ItemStrategy {

    ItemType getItemType();

    ItemDomain createItem(ItemRequest itemRequest);

    String returnSomethingCool(ItemRequest itemRequest);

}
