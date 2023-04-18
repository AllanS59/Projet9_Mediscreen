package com.openclassrooms.mediscreenPatient;

import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MediscreenPatientApplication implements CommandLineRunner {

	@Autowired
	private PatientService patientService;

	public static void main(String[] args) {
		SpringApplication.run(MediscreenPatientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Patient> allPatients = patientService.getAllPatients();
		System.out.println(allPatients.get(0).getFamily());

	}

}
