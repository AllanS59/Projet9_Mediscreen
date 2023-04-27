package com.openclassrooms.mediscreenNotes.repository;

import com.openclassrooms.mediscreenNotes.model.Note;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.text.ParseException;

@SpringBootTest
public class NoteRepositoryTests {

    @Autowired
    private NoteRepository noteRepository;

    @Test
    public void getAllNotesTest(){
        List<Note> allNotes = noteRepository.findAll();
        assertEquals(9, allNotes.size());
    }

    @Test
    public void getNoteById() {
        Optional<Note> note = noteRepository.findById("6447f94b66c5084ba01a8c8c");
        assertEquals("TestBorderline", note.get().getPatient());
    }

    @Test
    public void getNoteByPatId() {
        List<Note> notes = noteRepository.findByPatId(2);
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

        newNote = noteRepository.save(newNote);
        assertEquals(1, noteRepository.findByPatient("TestPatient").size());

        String newNoteId = newNote.getId();
        noteRepository.deleteById(newNoteId);
        assertEquals(0, noteRepository.findByPatient("TestPatient").size());
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
        newNote = noteRepository.save(newNote);


        newNote.setPatId(6);
        newNote.setPatient("UpdatedTestPatient");
        newNote.setNote("This is an Updated Note just for unit tests");

        newNote = noteRepository.save(newNote);
        assertEquals(1, noteRepository.findByPatient("UpdatedTestPatient").size());


        String newNoteId = newNote.getId();
        noteRepository.deleteById(newNoteId);
        assertEquals(0, noteRepository.findByPatient("UpdatedTestPatient").size());
    }
}
