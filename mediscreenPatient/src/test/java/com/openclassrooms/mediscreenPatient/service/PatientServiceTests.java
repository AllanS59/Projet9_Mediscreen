package com.openclassrooms.mediscreenPatient.service;

import com.openclassrooms.mediscreenPatient.model.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PatientServiceTests {

    @Autowired
    private PatientService patientService;


    @Test
    public void getAllPatientsTest(){
        List<Patient> allPatients = patientService.getAllPatients();
        assertEquals(4, allPatients.size());
    }

    @Test
    public void getPatientById(){
        Optional<Patient> patient = patientService.getPatientById(1);
        assertEquals("TestNone", patient.get().getFamily());
    }

    @Test
    public void getPatientByFamilyAndGiven(){
        List<Patient> patients = patientService.getPatientByFamilyAndGiven("TestBorderline", "Test");
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

        newPatient = patientService.addPatient(newPatient);
        assertEquals(1, patientService.getPatientByFamily("FamilyUnitTest").size());

        int newPatientId = newPatient.getPatientId();
        patientService.deletePatientById(newPatientId);

        assertEquals(0, patientService.getPatientByFamily("FamilyUnitTest").size());
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
        newPatient = patientService.addPatient(newPatient);



        newPatient.setGiven("NewGiven");
        newPatient.setSex("F");
        newPatient = patientService.updatePatient(newPatient);
        assertEquals(1, patientService.getPatientByFamily("FamilyUnitTest").size());
        assertEquals("NewGiven", patientService.getPatientByFamily("FamilyUnitTest").get(0).getGiven());
        assertEquals("F", patientService.getPatientByFamily("FamilyUnitTest").get(0).getSex());


        int newPatientId = newPatient.getPatientId();
        patientService.deletePatientById(newPatientId);
        assertEquals(0, patientService.getPatientByFamily("FamilyUnitTest").size());
    }

}
