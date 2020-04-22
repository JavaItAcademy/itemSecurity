package kg.itacademy.itemSecurity.service;

import kg.itacademy.itemSecurity.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAll();
    Item save (Item item);
    void delete(Long id);
}
