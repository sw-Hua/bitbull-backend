package com.songwen.businessservice;

import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class BitcoinDataService {
    private final AtomicReference<String> lastMessage = new AtomicReference<>();

    public void addMessage(String message) {
        lastMessage.set(message);
    }

    public String getLastMessage() {
        return lastMessage.get();
    }
}
