package com.songwen.trade;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "trades")
@Getter
@Setter
public class Trade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "btc_amount")
    private BigDecimal btcAmount;

    @Column(name = "price_per_btc")
    private BigDecimal pricePerBtc;

    @Column(name = "trade_time")
    private LocalDateTime tradeTime;

    // 构造函数、getter和setter省略...
}

