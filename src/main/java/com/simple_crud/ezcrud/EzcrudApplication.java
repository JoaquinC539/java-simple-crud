package com.simple_crud.ezcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication
@RestController
public class EzcrudApplication {
	@GetMapping("/api/new")
	public String add() throws SQLException, ClassNotFoundException {
		MensajeDAO mensajeDAO = new MensajeDAO();
		Mensaje msm = new Mensaje("Hola desde Spring", "Spring web");
		int registro = mensajeDAO.insertar(msm);
		String msg = ("Se inserto " + registro + " registro");
		return msg;
	}

	public static void main(String[] args) {
		SpringApplication.run(EzcrudApplication.class, args);
	}

}
