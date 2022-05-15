package com.example.NinjaGoldGame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })public class NinjaGoldGameApplication {

	public static void main(String[] args) {
		SpringApplication.run(NinjaGoldGameApplication.class, args);
	}

}
