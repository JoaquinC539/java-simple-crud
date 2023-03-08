package com.simple_crud.ezcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EzcrudApplication {
	@GetMapping("/index")
	public String hello() {
		String message = "Saludo1";
		return message;
	}

	@GetMapping("/second")
	public String second() {
		return "spage";
	}

	public static void main(String[] args) {
		SpringApplication.run(EzcrudApplication.class, args);
	}

}
