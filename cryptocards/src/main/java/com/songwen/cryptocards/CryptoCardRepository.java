package com.songwen.cryptocards;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CryptoCardRepository extends JpaRepository<CryptoCard, Long> {
    // Spring Data JPA handles implementation
}

