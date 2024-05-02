package com.ethan.ai115.pixelcollector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan("com.ethan.ai115.pixelcollector.model")
@EnableScheduling
public class PixelCollectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixelCollectorApplication.class, args);
	}

}
