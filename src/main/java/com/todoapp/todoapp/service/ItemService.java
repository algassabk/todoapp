package com.todoapp.todoapp.service;

import com.todoapp.todoapp.model.Category;
import com.todoapp.todoapp.model.Item;
import com.todoapp.todoapp.repository.CategoryRepository;
import com.todoapp.todoapp.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    public ItemService(ItemRepository itemRepository,
                       CategoryRepository categoryRepository) {
        this.itemRepository = itemRepository;
        this.categoryRepository = categoryRepository;
    }

    public List<Item> getItemsByCategory(Long categoryId) {
        return itemRepository.findByCategoryId(categoryId);
    }

    public Item createItem(Long categoryId, Item item) {
        Category category = categoryRepository.findById(categoryId).orElse(null);
        if (category != null) {
            item.setCategory(category);
            return itemRepository.save(item);
        }
        return null;
    }

    public Item getItem(Long categoryId, Long itemId) {
        return itemRepository.findById(itemId).orElse(null);
    }

    public Item updateItem(Long itemId, Item item) {
        Item existing = itemRepository.findById(itemId).orElse(null);
        if (existing != null) {
            existing.setName(item.getName());
            existing.setDescription(item.getDescription());
            existing.setDueDate(item.getDueDate());
            return itemRepository.save(existing);
        }
        return null;
    }

    public void deleteItem(Long itemId) {
        itemRepository.deleteById(itemId);
    }
}
