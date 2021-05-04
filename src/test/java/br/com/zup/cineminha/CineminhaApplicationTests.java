package br.com.zup.cineminha;

import br.com.zup.cineminha.ingressos.Filme;
import br.com.zup.cineminha.ingressos.FilmeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static java.time.temporal.ChronoUnit.HOURS;

@SpringBootTest
class CineminhaApplicationTests {

	@Autowired
	private FilmeRepository repository;

	@Test
	void contextLoads() {
		Filme homemAranha = new Filme("Homem Aranha", Duration.of(1, HOURS));

		repository.save(homemAranha);
	}

}
