package com.DvdSpringBootMvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.DvdSpringBootMvc")
@EntityScan(basePackages = "com.DvdSpringBootMvc.dto.entity")
@EnableJpaRepositories(basePackages = "com.DvdSpringBootMvc.model.persistence")
public class DvdSpringBootMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdSpringBootMvcApplication.class, args);
	}

}
