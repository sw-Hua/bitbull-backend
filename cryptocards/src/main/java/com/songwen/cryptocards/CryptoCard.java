package com.songwen.cryptocards;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "CryptoCards")
@Getter
@Setter
public class CryptoCard {

    @Id
    private Long id; // Assume Snowflake ID is generated and set before saving.

    @Column(name = "currency_type", length = 10, nullable = false) // Adjusted to match database
    private String currencyType;

    @Column(name = "currency_amount", precision = 19, scale = 8, nullable = false) // Adjusted to match database
    private BigDecimal currencyAmount;

    @Column(name = "card_holder", length = 100, nullable = false) // Adjusted to match database
    private String cardHolder;

    @Column(name = "expiry", nullable = false) // Adjusted to match database
    private Date expiry;

    @Column(name = "cvv", nullable = false) // Adjusted to match database
    private Integer cvv;

    // Constructors, getters, and setters are omitted for brevity
}
