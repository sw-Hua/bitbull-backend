package com.songwne.accountBalance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CryptoCombinedData {

    private String cryptoName;
    private String realTimePrice;
    private String realTimeDate;
    private String currencyUnit;
    private String lastMonthDate;
    private String lastMonthPrice;

    // Getters and setters

    public CryptoCombinedData() {
    }

    @Override
    public String toString() {
        return "CryptoCombinedData{" +
                "cryptoName='" + cryptoName + '\'' +
                ", realTimePrice='" + realTimePrice + '\'' +
                ", realTimeDate='" + realTimeDate + '\'' +
                ", currencyUnit='" + currencyUnit + '\'' +
                ", lastMonthDate='" + lastMonthDate + '\'' +
                ", lastMonthPrice='" + lastMonthPrice + '\'' +
                '}';
    }
}

