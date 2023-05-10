package com.openclassrooms.mediscreenDiabet;

import com.openclassrooms.mediscreenDiabet.beans.PatientBean;
import com.openclassrooms.mediscreenDiabet.service.AssessService;
import com.openclassrooms.mediscreenDiabet.service.PatientBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.List;


@SpringBootApplication
@EnableFeignClients("com.openclassrooms.mediscreenDiabet")
public class MediscreenDiabetApplication implements CommandLineRunner {

	@Autowired
	private PatientBeanService patientBeanService;

	@Autowired
	private AssessService assessService;


	public static void main(String[] args) {
		SpringApplication.run(MediscreenDiabetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<PatientBean> allPatients = patientBeanService.getAllPatients();
		for (PatientBean p : allPatients){
			System.out.println(assessService.assessDiabetStatement(p));
		}

	}

}
