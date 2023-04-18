package com.openclassrooms.mediscreenPatient.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PatientControllerTests {

    @Autowired
	public MockMvc mockMvc;

    @Test
	public void patientListPageTest() throws Exception {
        mockMvc.perform(get("/patient/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("patientList"));
    }

    @Test
    public void patientAddPageTest() throws Exception {
        mockMvc.perform(get("/patient/add"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("patientAdd"));
    }

    @Test
    public void patientUpdatePageTest() throws Exception {
        mockMvc.perform(get("/patient/update/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("patientUpdate"));
    }


}
