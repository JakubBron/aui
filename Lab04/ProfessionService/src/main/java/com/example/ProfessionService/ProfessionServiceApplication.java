package com.example.ProfessionService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProfessionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfessionServiceApplication.class, args);
	}

	@Bean
	@Qualifier("character-service")
	public RestTemplate professionServiceRestTemplate(
		@Value("${game.character-service.url}") String professionServiceUrl
	) {
		return new RestTemplateBuilder()
				.rootUri(professionServiceUrl)
				.build();
	}

}
