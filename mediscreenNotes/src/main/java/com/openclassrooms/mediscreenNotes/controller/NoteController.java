package com.openclassrooms.mediscreenNotes.controller;


import com.openclassrooms.mediscreenNotes.model.Note;
import com.openclassrooms.mediscreenNotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    @Autowired
    public NoteService noteService;


    @GetMapping("/notes")
    public String getNotes() {
        List<Note> listNotes =  noteService.getAllNotes();
        String json = new Gson().toJson(listNotes);
        return json;
    }

    @GetMapping("/note")
    public String getNoteById(@RequestParam(name = "id") String id) {

        Optional<Note> noteById = noteService.getNoteById(id);
        String json = new Gson().toJson(noteById.get());
        return json;
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
