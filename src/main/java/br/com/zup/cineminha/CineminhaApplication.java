package br.com.zup.cineminha;

import br.com.zup.cineminha.ingressos.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static java.time.LocalTime.now;
import static java.time.temporal.ChronoUnit.HOURS;

@SpringBootApplication
public class CineminhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CineminhaApplication.class, args);
	}


	@Bean
	CommandLineRunner runner(SessaoRepository sessaoRepository,
							 FilmeRepository filmeRepository,
							 SalaRepository salaRepository) {

		Filme homemAranha = new Filme("Homem Aranha", Duration.of(1, HOURS));
		Filme harryPotter = new Filme("Harry Potter", Duration.of(1, HOURS));
		Filme procurandoNemo = new Filme("Procurando Nemo", Duration.of(1, HOURS));

		Sala paris = new Sala("Paris");
		Sala roma = new Sala("Roma");
		Sala londres = new Sala("Londres");

		Sessao sessaoHomemAranha = new Sessao(now().plusHours(24), paris, homemAranha, new BigDecimal("30.0"));
		Sessao sessaoHarryPotter = new Sessao(now().plusHours(24), roma, harryPotter, new BigDecimal("20.0"));
		Sessao sessaoProcurandoNemo = new Sessao(now().plusHours(24), londres, procurandoNemo, new BigDecimal("50.0"));

		return (args) -> {
			filmeRepository.save(homemAranha);
			filmeRepository.save(harryPotter);
			filmeRepository.save(procurandoNemo);

			salaRepository.save(paris);
			salaRepository.save(roma);
			salaRepository.save(londres);

			sessaoRepository.save(sessaoHomemAranha);
			sessaoRepository.save(sessaoHarryPotter);
			sessaoRepository.save(sessaoProcurandoNemo);
		};
	}
}
