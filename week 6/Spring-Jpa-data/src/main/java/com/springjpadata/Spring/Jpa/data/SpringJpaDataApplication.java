package com.springjpadata.Spring.Jpa.data;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaDataApplication implements CommandLineRunner {
	//doesn't need instantiation because spring finds the repository

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaDataApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


	}
}
