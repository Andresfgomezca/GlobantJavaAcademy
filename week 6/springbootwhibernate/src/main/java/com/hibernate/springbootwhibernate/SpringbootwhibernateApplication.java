package com.hibernate.springbootwhibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootwhibernateApplication {
//this app is running the tutorial of springboot with hibernate, it is implementing the H2 memory db to verify
	//the database created with the model "book" using the JDBC url jdbc:h2:mem:test in http://localhost:8080/h2-console/
	public static void main(String[] args) {
		SpringApplication.run(SpringbootwhibernateApplication.class, args);
	}

}

