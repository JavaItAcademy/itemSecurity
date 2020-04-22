package kg.itacademy.itemSecurity.service.impl;

import kg.itacademy.itemSecurity.model.Item;
import kg.itacademy.itemSecurity.service.ItemService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ItemServiceImpl implements ItemService {
    private static Map<Long, Item> items = new HashMap<>();

    static {
        items.put(1L, Item.builder().id(1L).name("Java 8 book"). category("book").build());
        items.put(2L, Item.builder().id(2L).name("Spring Boot in Action"). category("book").build());
        items.put(3L, Item.builder().id(3L).name("Data Structures"). category("book").build());
    }

    @Override
    public List<Item> getAll() {
        return new ArrayList<>(items.values());
    }

    @Override
    public Item save(Item item) {
        items.put(item.getId(), item);
        return item;
    }

    @Override
    public void delete(Long id) {
        items.remove(id);
    }
}
