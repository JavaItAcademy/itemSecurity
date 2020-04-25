package kg.itacademy.itemSecurity.controller;

import kg.itacademy.itemSecurity.model.Item;
import kg.itacademy.itemSecurity.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Value("${it.academy.code}")
    private String code;

    @GetMapping
    public ResponseEntity getAll() {
        try {
            List<Item> items = itemService.getAll();
            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add")
    public ResponseEntity addItem(@Valid @RequestBody Item item) {
        item.setName(passwordEncoder.encode(item.getName()));
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
