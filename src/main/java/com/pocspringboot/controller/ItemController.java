package com.pocspringboot.controller;

import com.pocspringboot.model.request.ItemRequest;
import com.pocspringboot.service.ItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/items")
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public void createItem(@RequestBody ItemRequest itemRequest) {
        itemService.createItem(itemRequest);
    }
}
