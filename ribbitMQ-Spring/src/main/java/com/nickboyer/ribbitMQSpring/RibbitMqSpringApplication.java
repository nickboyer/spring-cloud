package com.nickboyer.ribbitMQSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource(locations = { "classpath:application-ribbit2.xml" })
public class RibbitMqSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbitMqSpringApplication.class, args);

	}
}
