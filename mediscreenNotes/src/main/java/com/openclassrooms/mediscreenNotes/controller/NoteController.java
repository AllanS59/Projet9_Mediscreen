package com.openclassrooms.mediscreenNotes.controller;


import com.openclassrooms.mediscreenNotes.model.Note;
import com.openclassrooms.mediscreenNotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    @Autowired
    public NoteService noteService;


    @GetMapping("/notes")
    public List<Note> getNotes() {
        List<Note> listNotes =  noteService.getAllNotes();
        return listNotes;
    }

    @GetMapping("/note/{id}")
    public Note getNoteById(@PathVariable(name = "id") String id) {

        Optional<Note> noteById = noteService.getNoteById(id);
        if(noteById.isPresent()){
            return noteById.get();
        }
        else {
            return null;
        }
    }

    @GetMapping("/note")
    public List<Note> getNoteByPatId(@RequestParam(name = "patId") int patId) {

        List<Note> noteByPatId = noteService.getNoteByPatient(patId);
        return noteByPatId;

    }



    @PostMapping("/note")
    public Note postNote(@RequestBody Note note) {
        noteService.addNote(note);
        return note;
    }


    @PutMapping("/note")
    public Note updateNote(@RequestBody Note note) {
       noteService.updateNote(note);
        return note;
    }


    @DeleteMapping("/note")
    public void deleteNoteById(@RequestParam(name = "id") String id) {
        noteService.deleteNoteById(id);
    }
}
