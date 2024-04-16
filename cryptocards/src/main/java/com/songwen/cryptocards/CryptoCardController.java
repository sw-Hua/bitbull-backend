package com.songwen.cryptocards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class CryptoCardController {

    private final CryptoCardService service;

    @Autowired
    public CryptoCardController(CryptoCardService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<CryptoCard> createCryptoCard(@RequestBody CryptoCard card) {
        return ResponseEntity.ok(service.createCryptoCard(card));
    }

    @GetMapping("/getAllCryptoCards")
    public ResponseEntity<List<CryptoCard>> getAllCryptoCards() {
        return ResponseEntity.ok(service.getAllCryptoCards());
    }
}

