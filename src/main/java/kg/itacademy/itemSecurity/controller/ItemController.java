package kg.itacademy.itemSecurity.controller;

import kg.itacademy.itemSecurity.model.Item;
import kg.itacademy.itemSecurity.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            List<Item> items = itemService.getAll();
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addItem(@RequestBody Item item) {
        Item it = itemService.save(item);
        return new ResponseEntity(it, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") Long id) {
        itemService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    // 404, 401, 403, 200 = OK
}
