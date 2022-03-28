package com.hibernate.bootstrappinghibernate5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Bootstrappinghibernate5Application {

	public static void main(String[] args) {
		SpringApplication.run(Bootstrappinghibernate5Application.class, args);
		//This app just implements the configuration of hibernate with spring where we define the
		// LocalSessionFactoryBean, DataSource and PlatformTransactionManager, as well as some Hibernate-specific
		// properties.
	}

}
