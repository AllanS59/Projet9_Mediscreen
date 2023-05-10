package com.openclassrooms.mediscreenNotes.service;

import com.openclassrooms.mediscreenNotes.model.Note;
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
public class NoteServiceTests {

    @Autowired
    private NoteService noteService;

    @Test
    public void getAllNotesTest(){
        List<Note> allNotes = noteService.getAllNotes();
        assertEquals(9, allNotes.size());
    }

    @Test
    public void getNoteById() {
        Optional<Note> note = noteService.getNoteById("6458be2df9e0225dc7367c89");
        assertEquals("TestBorderline", note.get().getPatient());
    }

    @Test
    public void getNoteByPatId() {
        List<Note> notes = noteService.getNoteByPatient(2);
        assertEquals(2, notes.size());
    }

    @Test
    public void newNoteTest() throws ParseException {

        String dateString = "2023-31-03";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        Note newNote = new Note();
        newNote.setPatId(6);
        newNote.setPatient("TestPatient");
        newNote.setNote("This is a Note just for unit tests");
        newNote.setDate(date);

        newNote = noteService.addNote(newNote);
        assertEquals(1, noteService.getNoteByPatient("TestPatient").size());

        String newNoteId = newNote.getId();
        noteService.deleteNoteById(newNoteId);
        assertEquals(0, noteService.getNoteByPatient("TestPatient").size());
    }


    @Test
    public void updatePatientTest() throws ParseException {

        String dateString = "2023-31-03";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        Note newNote = new Note();
        newNote.setPatId(6);
        newNote.setPatient("TestPatient");
        newNote.setNote("This is a Note just for unit tests");
        newNote.setDate(date);
        newNote = noteService.addNote(newNote);


        newNote.setPatId(6);
        newNote.setPatient("UpdatedTestPatient");
        newNote.setNote("This is an Updated Note just for unit tests");

        newNote = noteService.updateNote(newNote);
        assertEquals(1, noteService.getNoteByPatient("UpdatedTestPatient").size());

        String newNoteId = newNote.getId();
        noteService.deleteNoteById(newNoteId);
        assertEquals(0, noteService.getNoteByPatient("UpdatedTestPatient").size());
    }


}
