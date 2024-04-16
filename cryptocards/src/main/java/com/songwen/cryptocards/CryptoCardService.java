package com.songwen.cryptocards;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CryptoCardService {

    private final CryptoCardRepository repository;
    private final SnowflakeIdGenerator idGenerator;
    @Autowired
    public CryptoCardService(CryptoCardRepository repository, SnowflakeIdGenerator idGenerator) {
        this.repository = repository;
        this.idGenerator = idGenerator;
    }


    public List<CryptoCard> getAllCryptoCards() {
        return repository.findAll();
    }

    public CryptoCard createCryptoCard(CryptoCard card) {
        card.setId(idGenerator.nextId()); // 假设你有一个ID生成器
        return repository.save(card);
    }

}
