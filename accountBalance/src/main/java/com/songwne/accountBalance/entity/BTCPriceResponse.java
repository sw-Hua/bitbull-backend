package com.songwne.accountBalance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BTCPriceResponse {
    private String cryptoName;
    private String realTimePrice;
    private String realTimeDate;
    private String currencyUnit;
    private String lastMonthDate;
    private String lastMonthPrice;


}
