package com.todoapp.todoapp.controller;

import com.todoapp.todoapp.model.Item;
import com.todoapp.todoapp.service.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories/{categoryId}/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems(@PathVariable Long categoryId) {
        return itemService.getItemsByCategory(categoryId);
    }

    @PostMapping
    public Item createItem(@PathVariable Long categoryId,
                           @RequestBody Item item) {
        return itemService.createItem(categoryId, item);
    }

    @GetMapping("/{itemId}")
    public Item getItem(@PathVariable Long categoryId,
                        @PathVariable Long itemId) {
        return itemService.getItem(categoryId, itemId);
    }

    @PutMapping("/{itemId}")
    public Item updateItem(@PathVariable Long categoryId,
                           @PathVariable Long itemId,
                           @RequestBody Item item) {
        return itemService.updateItem(itemId, item);
    }

    @DeleteMapping("/{itemId}")
    public void deleteItem(@PathVariable Long categoryId,
                           @PathVariable Long itemId) {
        itemService.deleteItem(itemId);
    }
}
