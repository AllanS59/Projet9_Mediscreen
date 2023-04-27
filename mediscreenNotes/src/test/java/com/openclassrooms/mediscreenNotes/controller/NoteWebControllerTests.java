package com.openclassrooms.mediscreenNotes.controller;

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
public class NoteWebControllerTests {

    @Autowired
    public MockMvc mockMvc;


    @Test
    public void noteListPageTest() throws Exception {
        mockMvc.perform(get("/web/note/list"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("noteList"));
    }


    @Test
    public void noteAddPageTest() throws Exception {
        mockMvc.perform(get("/web/note/add"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("noteAdd"));
    }


    @Test
    public void patientUpdatePageTest() throws Exception {
        mockMvc.perform(get("/web/note/update/6447f94b66c5084ba01a8c8c"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("noteUpdate"));
    }


}
