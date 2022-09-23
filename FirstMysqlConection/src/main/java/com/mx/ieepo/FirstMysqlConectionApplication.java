package com.mx.ieepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
@EnableScheduling //habilita job
public class FirstMysqlConectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMysqlConectionApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
		    public void addCorsMappings(CorsRegistry registry) {
		        registry.addMapping("/**")
		                .allowedOrigins("http://localhost:4200")
		                .allowedMethods("*");
		    };
		};
	}

	
	

}
