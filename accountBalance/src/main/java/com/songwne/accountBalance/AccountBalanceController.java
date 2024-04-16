package com.songwne.accountBalance;

import com.songwen.Btc.Btc;
import com.songwen.Btc.BtcService;
import com.songwne.accountBalance.entity.CryptoCombinedData;
import com.songwne.accountBalance.entity.LastMonthData;
import com.songwne.accountBalance.entity.RealTimeBTC;
import com.songwne.accountBalance.entity.RealTimeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AccountBalanceController {

    @Autowired
    private AccountBalanceService accountBalanceService;


    @GetMapping(value = "/test")
    private String test() {
        Btc btc = accountBalanceService.getBtcPrice();
        return "Test";
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


    @GetMapping("/combined")
    public CryptoCombinedData getCombinedData() {
        RestTemplate restTemplate = new RestTemplate();

        String REAL_TIME_API_URL = "https://min-api.cryptocompare.com/data/price?fsym=BTC&tsyms=USD";
        String LAST_MONTH_API_URL = "https://www.alphavantage.co/query?function=DIGITAL_CURRENCY_DAILY&symbol=BTC&market=CNY&apikey=E0227QUMBUGBD8O0";



        RealTimeBTC realTimeBTC = restTemplate.getForObject(REAL_TIME_API_URL, RealTimeBTC.class);
        System.out.println("realTimeBtc: ");
        System.out.println(realTimeBTC);

        // Get real-time data
        RealTimeData realTimeData = restTemplate.getForObject(REAL_TIME_API_URL, RealTimeData.class);
        System.out.println("realTimeData: ");
        System.out.println(realTimeData);


        // Get last month's data
        LastMonthData lastMonthData = restTemplate.getForObject(LAST_MONTH_API_URL, LastMonthData.class);
        System.out.println("lastMonthData: ");
        System.out.println(lastMonthData);
        // Combine data
        CryptoCombinedData combinedData = new CryptoCombinedData();
        combinedData.setCryptoName("");
        combinedData.setRealTimePrice(realTimeData.getRealTimePrice());
        combinedData.setRealTimeDate(realTimeData.getRealTimeDate());
        combinedData.setCurrencyUnit(realTimeData.getCurrencyUnit());
        combinedData.setLastMonthDate(lastMonthData.getLastMonthDate());
        combinedData.setLastMonthPrice(lastMonthData.getLastMonthPrice());

        return combinedData;
    }



}
