package com.pocspringboot.service;

import com.pocspringboot.model.domain.items.ItemDomain;
import com.pocspringboot.model.request.ItemRequest;
import com.pocspringboot.repository.ItemRepository;
import com.pocspringboot.strategy.factory.ItemFactory;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;

    private final ItemFactory itemFactory;

    public void createItem(ItemRequest itemRequest) {
        ItemDomain item = itemFactory.getItemStrategy(itemRequest.getItemType()).createItem(itemRequest);
        itemRepository.save(item);
    }
}
