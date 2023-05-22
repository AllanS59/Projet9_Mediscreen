package com.openclassrooms.mediscreenDiabet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("com.openclassrooms.mediscreenDiabet")
public class MediscreenDiabetApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(MediscreenDiabetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

			System.out.println("Application Started");


	}

}
