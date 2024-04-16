package com.songwen.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bitcoin")
@CrossOrigin(origins = "http://localhost:4200")
public class BitcoinDataController {

    private final BitcoinDataService bitcoinDataService;

    @Autowired
    public BitcoinDataController(BitcoinDataService bitcoinDataService) {
        this.bitcoinDataService = bitcoinDataService;
    }

    @GetMapping("/latest-message")
    public ResponseEntity<String> getLatestBitcoinMessage() {
        String lastMessage = bitcoinDataService.getLastMessage();
        if (lastMessage != null) {
            return ResponseEntity.ok(lastMessage);
        } else {
            return ResponseEntity.noContent().build();
        }
    }
}
