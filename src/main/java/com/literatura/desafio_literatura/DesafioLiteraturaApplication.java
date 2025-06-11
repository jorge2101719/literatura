package com.literatura.desafio_literatura;

import com.literatura.desafio_literatura.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioLiteraturaApplication implements CommandLineRunner {

//	@Autowired
//	private LibroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioLiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.mostrarMenu();
	}
}
