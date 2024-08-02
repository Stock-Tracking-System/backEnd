package com.project.stockTracking;

import org.springframework.boot.SpringApplication;

public class TestStockTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.from(StockTrackingApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
