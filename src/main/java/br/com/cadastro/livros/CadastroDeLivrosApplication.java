package br.com.cadastro.livros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = { "br.com.cadastro.livros" })
public class CadastroDeLivrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeLivrosApplication.class, args);
	}

}
