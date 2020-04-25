package kg.itacademy.itemSecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/extra")
public class ExtraController {
    @GetMapping("/cashier")
    public ResponseEntity cashier() {
        return new ResponseEntity(null, HttpStatus.CREATED);
    }
    @GetMapping("/check")
    public ResponseEntity check() {
        return new ResponseEntity(null, HttpStatus.CREATED);
    }
    @GetMapping("/general")
    public ResponseEntity general() {
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/shared")
    public ResponseEntity shared() {
        return new ResponseEntity(null, HttpStatus.CREATED);
    }

}
