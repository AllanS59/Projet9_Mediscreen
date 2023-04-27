package com.openclassrooms.mediscreenNotes.service;

import com.openclassrooms.mediscreenNotes.model.Note;
import com.openclassrooms.mediscreenNotes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    /**
     * GET all Notes from database
     * @return List<Note> list of all notes.
     */
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    /**
     * GET a note by note Id from database, if exists
     * @param id the note Id of the note to find
     * @return Optional<Note> note found if any.
     */
    public Optional<Note> getNoteById(String id) {
        return noteRepository.findById(id);
    }


    /**
     * GET a note by patient ID from database, if exists
     * @param patientId the name of the patient
     * @return List<Note> notes found if any.
     */
    public List<Note> getNoteByPatient(int patientId) {
        return noteRepository.findByPatId(patientId);
    }


    /**
     * GET a note by Name from database, if exists
     * @param patientName the name of the patient
     * @return List<Note> notes found if any.
     */
    public List<Note> getNoteByPatient(String patientName) {
        return noteRepository.findByPatient(patientName);
    }


    /**
     * POST a new post into database
     * @param note the note to save in database
     * @return note the note to save in database
     */
    public Note addNote (Note note){
        noteRepository.insert(note);
        return note;
    }

    /**
     * UPDATE a post into database
     * @param note the note to update in database
     * @return note the note to update in database
     */
    public Note updateNote (Note note){
        noteRepository.save(note);
        return note;
    }

    /**
     * DELETE a note by Id
     * @param id the ID of the patient to delete
     */
    public void deleteNoteById (String id){
        noteRepository.deleteById(id);
    }


}
