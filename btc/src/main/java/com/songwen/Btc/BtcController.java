package com.songwen.Btc;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BtcController {
    private final ExternalAPIService externalAPIService;


    @Autowired
    private BtcService btcService;

    @Autowired
    public BtcController(ExternalAPIService externalAPIService) {
        this.externalAPIService = externalAPIService;
    }

    @GetMapping(value = "/btc/price")
    private double getBtcPrice() {
        return btcService.getBtcPrice();
    }

    @GetMapping(value = "/")
    private String helloWorld() {
        return "Hello World!";
    }


    @GetMapping("/fullBtc")
    public String getFullBtcData() {
        String apiKey = "E0227QUMBUGBD8O0"; // Replace with your own API key
        String symbol = "BTC";
        String market = "CNY";

        String url = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_MONTHLY&symbol=" + symbol + "&market=" + market + "&apikey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);

        return result;
    }


    @CrossOrigin(origins = "http://localhost:4200")

    @GetMapping("/btc")
    public ResponseEntity<?> getFilterBtcData() {
        String apiKey = "E0227QUMBUGBD8O0";
        String symbol = "BTC";
        String market = "SGD";

        String url = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_MONTHLY&symbol=" + symbol + "&market=" + market + "&apikey=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        if (response.getStatusCode() == HttpStatus.OK) {
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

            // 构建新的 JSON 响应
            JsonObject responseJson = new JsonObject();
            responseJson.add("Meta Data", resultJson.getAsJsonObject("Meta Data"));
            responseJson.add("Time Series (Digital Currency Monthly)", filteredData);

            return ResponseEntity.ok(responseJson.toString());
        } else {
            // 返回错误信息
            return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
        }
    }

    @GetMapping("/fetch-and-send")
    public ResponseEntity<String> fetchAndSendBitcoinData() {
        externalAPIService.fetchAndSendBitcoinData();
        return ResponseEntity.ok("Bitcoin data has been fetched and sent to Kafka topic.");
    }
}


