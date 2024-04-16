package com.songwen.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;

    @Autowired
    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public Trade recordTrade(BigDecimal amount, BigDecimal pricePerBtc) {
        Trade trade = new Trade();
        trade.setBtcAmount(amount);
        trade.setPricePerBtc(pricePerBtc);
        trade.setTradeTime(LocalDateTime.now()); // 用当前时间作为交易时间
        return tradeRepository.save(trade);
    }

    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    // 其他业务方法...
}
