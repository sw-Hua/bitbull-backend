package com.songwen.Btc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BtcService {

    public Btc getBtcPrice() {
        String url = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD";
        RestTemplate restTemplate = new RestTemplate();
        Btc btc = restTemplate.getForObject(url, Btc.class);
        return btc;
    }
}
