package com.openclassrooms.mediscreenPatient.repository;

import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PatientRepositoryTests {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void getAllPatientsTest(){
        List<Patient> allPatients = patientRepository.findAll();
        assertEquals(4, allPatients.size());
    }

    @Test
    public void getAllPatientById() {
        Optional<Patient> patient = patientRepository.findById(1);
        assertEquals("TestNone", patient.get().getFamily());
    }

    @Test
    public void getPatientByFamilyAndGivenTest(){
        List<Patient> patients = patientRepository.findByFamilyAndGiven("TestBorderline", "Test");
        assertEquals("TestBorderline",patients.get(0).getFamily());
        assertEquals("Test", patients.get(0).getGiven());
        assertEquals("2 High St", patients.get(0).getAddress());
    }

    @Test
    public void newPatientTest() throws ParseException {

        String dateString = "1992-31-12";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        Patient newPatient = new Patient();
        newPatient.setFamily("FamilyUnitTest");
        newPatient.setGiven("GivenUnitTest");
        newPatient.setDob(date);
        newPatient.setSex("M");

        newPatient = patientRepository.save(newPatient);
        assertEquals(1, patientRepository.findByFamily("FamilyUnitTest").size());

        int newPatientId = newPatient.getPatientId();
        patientRepository.deleteById(newPatientId);

        assertEquals(0, patientRepository.findByFamily("FamilyUnitTest").size());
    }


    @Test
    public void updatePatientTest() throws ParseException {

        String dateString = "1992-31-12";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        Patient newPatient = new Patient();
        newPatient.setFamily("FamilyUnitTest");
        newPatient.setGiven("GivenUnitTest");
        newPatient.setDob(date);
        newPatient.setSex("M");
        newPatient = patientRepository.save(newPatient);



        newPatient.setGiven("NewGiven");
        newPatient.setSex("F");
        newPatient = patientRepository.save(newPatient);
        assertEquals(1, patientRepository.findByFamily("FamilyUnitTest").size());
        assertEquals("NewGiven", patientRepository.findByFamily("FamilyUnitTest").get(0).getGiven());
        assertEquals("F", patientRepository.findByFamily("FamilyUnitTest").get(0).getSex());


        int newPatientId = newPatient.getPatientId();
        patientRepository.deleteById(newPatientId);
        assertEquals(0, patientRepository.findByFamily("FamilyUnitTest").size());
    }  



}
