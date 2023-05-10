package com.openclassrooms.mediscreenNotes.repository;

import com.openclassrooms.mediscreenNotes.model.Note;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public class InitialNoteDataCreator {

    private NoteRepository noteRepository;


    public void createData () throws ParseException {

        String dateString = "2023-31-03";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);
        Note note = new Note();

        note.setId("6458be20f9e0225dc7367c88"); note.setPatId(1); note.setPatient("TestNone");
        note.setNote("Patient states that they are 'feeling terrific' Weight at or below recommended level");
        note.setDate(date); note = noteRepository.save(note);

        note.setId("6458be2df9e0225dc7367c89"); note.setPatId(2); note.setPatient("TestBorderline");
        note.setNote("Patient states that they are feeling a great deal of stress at work Patient also complains that their hearing seems Abnormal as of late");
        note.setDate(date); note = noteRepository.save(note);

        note.setId("6458be40f9e0225dc7367c8a"); note.setPatId(2); note.setPatient("TestBorderline");
        note.setNote("Patient states that they have had a Reaction to medication within last 3 months Patient also complains that their hearing continues to be problematic");
        note.setDate(date); note = noteRepository.save(note);

        note.setId("6458be51f9e0225dc7367c8b"); note.setPatId(3); note.setPatient("TestInDanger");
        note.setNote("Patient states that they are short term Smoker ");
        note.setDate(date); note = noteRepository.save(note);

        note.setId("6458be5cf9e0225dc7367c8c"); note.setPatId(3); note.setPatient("TestInDanger");
        note.setNote("Patient states that they quit within last year Patient also complains that of Abnormal breathing spells Lab reports Cholesterol LDL high");
        note.setDate(date); note = noteRepository.save(note);

        note.setId("6458be66f9e0225dc7367c8d"); note.setPatId(4); note.setPatient("TestEarlyOnset");
        note.setNote("Patient states that walking up stairs has become difficult Patient also complains that they are having shortness of breath Lab results indicate Antibodies present elevated Reaction to medication");
        note.setDate(date); note = noteRepository.save(note);

        note.setId("6458be70f9e0225dc7367c8e"); note.setPatId(4); note.setPatient("TestEarlyOnset");
        note.setNote("Patient states that they are experiencing back pain when seated for a long time");
        note.setDate(date); note = noteRepository.save(note);

        note.setId("6458be7af9e0225dc7367c8f"); note.setPatId(4); note.setPatient("TestEarlyOnset");
        note.setNote("Patient states that they are a short term Smoker Hemoglobin A1C above recommended level");
        note.setDate(date); note = noteRepository.save(note);

        note.setId("6458be90f9e0225dc7367c90"); note.setPatId(4); note.setPatient("TestEarlyOnset");
        note.setNote("Patient states that Body Height, Body Weight, Cholesterol, Dizziness and Reaction");
        note.setDate(date); note = noteRepository.save(note);

    }

}
