package dev.stranik.lab16;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lab16Application {

	public static void main(String[] args) {
		System.out.println("http://localhost:8080/");
		SpringApplication.run(Lab16Application.class, args);
	}

}
