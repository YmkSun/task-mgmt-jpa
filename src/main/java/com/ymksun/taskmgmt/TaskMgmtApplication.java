package com.ymksun.taskmgmt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("deprecation")
@SpringBootApplication
public class TaskMgmtApplication {

	private static final Logger LOGGER = LogManager.getLogger(TaskMgmtApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TaskMgmtApplication.class, args);
		LOGGER.info("Applaction Started...");
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:4200", "http://localhost:8080")
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}

	public static void logResult(String result, String type) {
		switch (type) {
			case "INFO":
				LOGGER.info(result);
				break;
			case "DEBUG":
				LOGGER.debug(result);
				break;
		}
	}

}
