package com.openclassrooms.mediscreenNotes.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.openclassrooms.mediscreenNotes.model.Note;
import com.openclassrooms.mediscreenNotes.service.NoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class NoteControllerTests {

    @Autowired
    public MockMvc mockMvc;

    @Autowired
    public NoteService noteService;


    @Test
    public void getNotesListTest () throws Exception   {
        mockMvc.perform(get("/notes")).andExpect(status().isOk()).andExpect(jsonPath("$[0].patient", is("TestNone")));
    }

    @Test
    public void getNoteByIdTest () throws Exception   {
        mockMvc.perform(get("/note?id=6447f94b66c5084ba01a8c8c")).andExpect(status().isOk()).andExpect(jsonPath("$.patient", is("TestBorderline")));
    }


    @Test
    public void postNoteTest() throws Exception {

        // Create patient via controller
        String jsonNote = "{\"patId\":\"6\",\"patient\":\"TestPatient\",\"note\":\"Fake notes for unit tests\",\"date\":\"2023-04-20T22:00:00.000Z\"}";

        mockMvc.perform(
                post("/note").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonNote))
                .andExpect(status().isOk()).andReturn();

        // delete the patient of this test
        Note testNote = noteService.getNoteByPatient(6).get(0);
        noteService.deleteNoteById(testNote.getId());
    }


    @Test
    public void putNoteTest() throws Exception {

        // Create an initial Patient and add in database
        String dateString = "1992-31-12";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        Note testNote = new Note();
        testNote.setPatId(10);
        testNote.setPatient("TestPatient");
        testNote.setNote("Fake notes for unit test");
        testNote.setDate(date);


        testNote = noteService.addNote(testNote);
        String noteId = testNote.getId();

        // Update patient via controller
        String jsonNote = "{\"id\":\"" + noteId + "\",\"patId\":\"6\",\"patient\":\"UpdatedTestPatient\",\"note\":\"Fake notes for unit tests\",\"date\":\"2023-04-20T22:00:00.000Z\"}";

        mockMvc.perform(
                put("/note").contentType(MediaType.APPLICATION_JSON).characterEncoding("UTF-8").content(jsonNote))
                .andExpect(status().isOk()).andReturn();
        assertEquals("UpdatedTestPatient", noteService.getNoteById(noteId).get().getPatient());


        // delete the patient of this test;
        noteService.deleteNoteById(testNote.getId());
    }


}
