package com.songwen.Btc;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledDataService {

    private final ExternalAPIService externalAPIService;

    public ScheduledDataService(ExternalAPIService externalAPIService) {
        this.externalAPIService = externalAPIService;
    }

    @Scheduled(fixedDelay = 300000) // 每5分钟执行一次
    public void fetchAndSendDataAutomatically() {
        externalAPIService.fetchAndSendBitcoinData();
    }
}
