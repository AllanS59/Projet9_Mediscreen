package com.openclassrooms.mediscreenPatient.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.CoreMatchers.is;

import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.service.PatientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTests {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public PatientService patientService;


    @Test
    public void getPatientsListTest () throws Exception   {
        mockMvc.perform(get("/patients")).andExpect(status().isOk()).andExpect(jsonPath("$[0].family", is("TestNone")));
    }

    @Test
    public void getPatientByIdTest () throws Exception   {
        mockMvc.perform(get("/patient?patientId=2")).andExpect(status().isOk()).andExpect(jsonPath("$.family", is("TestBorderline")));
    }

    @Test
    public void postPatientTest() throws Exception {

        // Create patient via controller
        String jsonPatient = "{\"family\":\"TestFamily\",\"given\":\"TestGiven\",\"dob\":\"1992-12-31\",\"sex\":\"M\",\"address\":\"Test Address\",\"phone\":\"111-555-1234\"}";

        mockMvc.perform(
                post("/patient").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonPatient))
                .andExpect(status().isOk()).andReturn();

        // delete the patient of this test
        Patient testPatient = patientService.getPatientByFamily("TestFamily").get(0);
        patientService.deletePatientById(testPatient.getPatientId());
    }


    @Test
    public void putPatientTest() throws Exception {

        // Create an initial Patient and add in database
        String dateString = "1992-31-12";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        Patient testPatient = new Patient();
        testPatient.setFamily("TestFamily");
        testPatient.setGiven("TestGiven");
        testPatient.setDob(date);
        testPatient.setSex("M");
        testPatient.setAddress("5 test address");
        testPatient.setPhone("111-333-555");

        testPatient = patientService.addPatient(testPatient);
        int patientId = testPatient.getPatientId();

        // Update patient via controller
        String jsonPatient = "{\"patientId\":" + patientId + ",\"family\":\"UpdatedTestFamily\",\"given\":\"UpdatedTestGiven\",\"dob\":\"1992-12-31\",\"sex\":\"M\",\"address\":\"Updated Test Address\",\"phone\":\"111-555-1234\"}";

        mockMvc.perform(
                put("/patient?patientId="+ patientId).contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonPatient))
                .andExpect(status().isOk()).andReturn();
        assertEquals("UpdatedTestFamily", patientService.getPatientById(patientId).get().getFamily());


    // delete the patient of this test;
        patientService.deletePatientById(patientId);
    }



    @Test
    public void deletePatientTest() throws Exception {

        // Create an initial Patient and add in database
        String dateString = "1992-31-12";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        Patient testPatient = new Patient();
        testPatient.setFamily("TestFamily");
        testPatient.setGiven("TestGiven");
        testPatient.setDob(date);
        testPatient.setSex("M");
        testPatient.setAddress("5 test address");
        testPatient.setPhone("111-333-555");

        testPatient = patientService.addPatient(testPatient);
        int patientId = testPatient.getPatientId();

        mockMvc.perform(delete("/patient?patientId="+ patientId)).andExpect(status().isOk());

        assertEquals(0, patientService.getPatientByFamily("TestFamily").size());
    }

}
