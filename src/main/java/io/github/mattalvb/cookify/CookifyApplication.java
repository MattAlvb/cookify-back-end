package io.github.mattalvb.cookify;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.github.mattalvb.cookify.domain.entity.Assinante;
import io.github.mattalvb.cookify.domain.repositorio.Assinantes;

@SpringBootApplication
public class CookifyApplication {

	@Bean
	public CommandLineRunner init(@Autowired Assinantes assinantes) {
		return args -> {
			Assinante assinante = new Assinante("Jorge");
			assinantes.salvar(assinante);

			Assinante assinante2 = new Assinante("vini viado");
			assinantes.salvar(assinante2);

			Assinante assinante3 = new Assinante("dan safado");
			assinantes.salvar(assinante3);

			List<Assinante> todoAssinantes = assinantes.obterTodos();
			todoAssinantes.forEach(System.out::println);

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(CookifyApplication.class, args);
	}

}
