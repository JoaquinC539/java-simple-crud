package com.simple_crud.ezcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EzcrudApplication {
	@GetMapping("/api/new")
	public String hello() {
		String message = "Saludo1";
		return message;
	}

	@GetMapping("/api/edit")
	public String second() {
		return "spage";
	}

	public static void main(String[] args) {
		SpringApplication.run(EzcrudApplication.class, args);
	}

}
