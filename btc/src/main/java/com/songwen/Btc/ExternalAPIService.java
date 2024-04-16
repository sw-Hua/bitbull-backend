package com.songwen.Btc;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.songwen.Btc.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalAPIService {

    private final KafkaProducerService kafkaProducerService;

    @Autowired
    public ExternalAPIService(KafkaProducerService kafkaProducerService) {
        this.kafkaProducerService = kafkaProducerService;
    }

    @Scheduled(fixedRate = 300000) // 每300000毫秒（即5分钟）执行一次
    public void fetchAndSendBitcoinData() {
        String apiKey = "E0227QUMBUGBD8O0";
        String symbol = "BTC";
        String market = "SGD";
        String url = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_MONTHLY&symbol=" + symbol + "&market=" + market + "&apikey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // 处理API响应
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            JsonObject resultJson = JsonParser.parseString(response.getBody()).getAsJsonObject();
            JsonObject timeSeries = resultJson.getAsJsonObject("Time Series (Digital Currency Monthly)");

            // 进行时间过滤，只保留指定时间段内的数据
            JsonObject filteredData = new JsonObject();
            timeSeries.entrySet().stream()
                    .filter(entry -> {
                        String date = entry.getKey();
                        return date.compareTo("2023-01-01") >= 0 && date.compareTo("2024-04-01") <= 0;
                    })
                    .forEach(entry -> filteredData.add(entry.getKey(), entry.getValue()));

            // 将过滤后的数据构建为新的JSON响应对象
            JsonObject responseJson = new JsonObject();
            responseJson.add("Meta Data", resultJson.getAsJsonObject("Meta Data"));
            responseJson.add("Time Series (Digital Currency Monthly)", filteredData);

            // 发送过滤后的数据到Kafka
            kafkaProducerService.sendBitcoinData(responseJson.toString());
        } else {
            // 可以在这里处理错误的情况，或者发送一些错误信息到Kafka
            String error = String.format("Failed to fetch data: %s", response.getStatusCode());
            kafkaProducerService.sendBitcoinData(error);
        }
    }
}
