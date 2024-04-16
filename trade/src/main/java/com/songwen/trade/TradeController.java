package com.songwen.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/trades")
@CrossOrigin(origins = "http://localhost:4200")
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }


    /*
        {
            "btcAmount": 1,
            "pricePerBtc": 123456
         }
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/btc")
    public ResponseEntity<Trade> recordTrade3(@RequestBody Trade trade) {
        Trade recordedTrade = tradeService.recordTrade(trade.getBtcAmount(), trade.getPricePerBtc());
        return ResponseEntity.ok(recordedTrade);
    }

    @GetMapping("/getTransactionDate")
    public ResponseEntity<List<Trade>> getAllTrades() {
        List<Trade> trades = tradeService.getAllTrades();
        return ResponseEntity.ok(trades);
    }

    // 其他控制器方法...
}

