package com.example.CharacterService.Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
	private final String characterServiceURL;
	private final String professionServiceURL;

	public GatewayApplication(
		@Value("${game.character-service.url}") String characterURL,
		@Value("${game.profession-service.url}") String professionURL
	){
		this.characterServiceURL = characterURL;
		this.professionServiceURL = professionURL;
	}

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	@Bean
	public RouteLocator router(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("professions", route -> route
				.path("/api/professions", "/api/professions/{uuid}")
				.uri(professionServiceURL)
			)
			.route("characters", route -> route
				.path("/api/characters", "/api/characters/{uuid}", "api/professions/{uuid}/characters")
				.uri(characterServiceURL)
			)
			.build();
	}
}
