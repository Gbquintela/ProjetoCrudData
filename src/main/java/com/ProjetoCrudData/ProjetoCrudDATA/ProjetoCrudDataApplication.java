package com.ProjetoCrudData.ProjetoCrudDATA;

import com.ProjetoCrudData.ProjetoCrudDATA.Controller.MainController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

@SpringBootApplication
public class ProjetoCrudDataApplication implements CommandLineRunner {
	@Autowired // Injeção automática de dependência do MainController
	private MainController controller; // Controlador principal da aplicação


	public static void main(String[] args) {
		SpringApplication.run(ProjetoCrudDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	controller.controllerMain(); // Chama o metodo controllerMain() do MainController
	}
}
