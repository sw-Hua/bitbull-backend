package com.songwne.accountBalance.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LastMonthData {

    private String lastMonthDate;
    private String lastMonthPrice;

    // Getters and setters

    public LastMonthData() {
    }

    @Override
    public String toString() {
        return "LastMonthData{" +
                "lastMonthDate='" + lastMonthDate + '\'' +
                ", lastMonthPrice='" + lastMonthPrice + '\'' +
                '}';
    }
}

