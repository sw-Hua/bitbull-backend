package com.songwen.businessservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {

    private final BitcoinDataService bitcoinDataService;

    @Autowired
    public KafkaConsumerService(BitcoinDataService bitcoinDataService) {
        this.bitcoinDataService = bitcoinDataService;
    }

    @KafkaListener(topics = "bitcoin-data-topic", groupId = "bitcoin-data-group")
    public void listenToBitcoinData(String message) {
        System.out.println("Received message from Kafka: " + message);
        bitcoinDataService.addMessage(message);  // 将消息保存到服务中
    }
}


