package com.songwen.Btc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BtcService {

    public String getBtc() {
        String url = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForObject(url, String.class));
        return restTemplate.getForObject(url, String.class);
    }

    public double getBtcPrice() {
        String url = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url, String.class);

        // 截取 USD 后面的数字部分
        String usdString = response.substring(response.indexOf(":") + 1, response.length() - 1);
        // 转换成 double 类型
        double usdValue = Double.parseDouble(usdString);

        return usdValue;
    }
}
