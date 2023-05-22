package com.openclassrooms.mediscreenNotes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class MediscreenNotesApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(MediscreenNotesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			System.out.println("Application started");

	}
}
