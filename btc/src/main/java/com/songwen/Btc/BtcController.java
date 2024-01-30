package com.songwen.Btc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class BtcController {

    @Autowired
    private BtcService btcService;

    @RequestMapping("/btc")
    public String getPrice() {
        return "btc price";
    }

    @GetMapping(value = "/btc/price")
    private Double getBtcPrice() {
        Btc btc = btcService.getBtcPrice();
        return btc.getUSD();
    }
}


