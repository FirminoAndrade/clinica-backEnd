package br.com.clinicaapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("prod")
public class ProdConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public void instaciaDeDados() {
		this.dbService.instaciaBaseDeDados();
	}
}