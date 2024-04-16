package com.songwen.Btc;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Btc {
    private double USD;

    @Override
    public String toString() {
        return "Btc{" +
                "USD=" + USD +
                '}';
    }
}
