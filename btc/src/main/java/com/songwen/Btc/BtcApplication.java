package com.songwen.Btc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BtcApplication {
	public static void main(String[] args) {
		SpringApplication.run(BtcApplication.class, args);
	}
}
