package com.songwne.accountBalance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RealTimeData {

    private String cryptoName;
    private String realTimePrice;
    private String realTimeDate;
    private String currencyUnit;

    // Getters and setters


    public RealTimeData() {
    }


    @Override
    public String toString() {
        return "RealTimeData{" +
                "cryptoName='" + cryptoName + '\'' +
                ", realTimePrice='" + realTimePrice + '\'' +
                ", realTimeDate='" + realTimeDate + '\'' +
                ", currencyUnit='" + currencyUnit + '\'' +
                '}';
    }
}
