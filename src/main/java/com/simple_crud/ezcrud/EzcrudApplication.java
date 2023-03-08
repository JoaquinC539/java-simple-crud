package com.simple_crud.ezcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@RestController
public class EzcrudApplication {
	@PostMapping("/api/new")
	public String add(@RequestParam String message, @RequestParam String author)
			throws SQLException, ClassNotFoundException {
		MensajeDAO mensajeDAO = new MensajeDAO();
		Mensaje msm = new Mensaje(message, author);
		int registro = mensajeDAO.insertar(msm);
		String msg = ("Se inserto " + registro + " registro");
		return msg;
	}

	public static void main(String[] args) {
		SpringApplication.run(EzcrudApplication.class, args);
	}

}
