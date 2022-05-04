
package com.bookapp.bookappapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookappApiApplication {
	private final Logger log =LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(BookappApiApplication.class, args);
		System.out.println("hai");
	}

}


