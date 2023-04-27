package com.openclassrooms.mediscreenNotes.controller;

import com.openclassrooms.mediscreenNotes.model.Note;
import com.openclassrooms.mediscreenNotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;


@Controller
public class NoteWebController {

    @Autowired
    private NoteService noteService;

    @RequestMapping("/web/note/list")
    public String listNotes(Model model) {
        List<Note> listNotes = noteService.getAllNotes();
        model.addAttribute("listNotes", listNotes);
        return "noteList";
    }

    @GetMapping("/web/note/add")
    public String addNoteForm(Note note) {
        return "noteAdd";
    }

    @PostMapping("/web/note/validate")
    public String validate(@Valid @DateTimeFormat(pattern= "yyyy-MM-dd") Note note, BindingResult result, Model model) {
        // If no errors in data provided by user, save data and go back to 'list' page
        if (!result.hasErrors()) {
            note.setDate(new Date());
            noteService.addNote(note);
            List<Note> listNotes = noteService.getAllNotes();
            model.addAttribute("listNotes", listNotes);
            return "redirect:/web/note/list";
        }
        // else stay on the current page
        return "noteAdd";
    }

    @GetMapping("/web/note/update/{id}")
    public String showUpdateForm(@PathVariable("id") String id, Model model) {
        Note note = noteService.getNoteById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Note Id:" + id));
        model.addAttribute("note", note);
        return "noteUpdate";
    }


    @PostMapping("/web/note/update/{id}")
    public String updateNote(@PathVariable("id") String id, @Valid Note note, BindingResult result, Model model) {
        // If errors in data provided by user, stay on current page
        if (result.hasErrors()) {
            return "noteUpdate";
        }
        // If no error, save data into database and go back to 'List' page
        note.setId(id);
        note.setDate(new Date());
        noteService.updateNote(note);
        List<Note> listNotes = noteService.getAllNotes();
        model.addAttribute("listNotes", listNotes);
        return "redirect:/web/note/list";
    }


    @GetMapping("/web/note/delete/{id}")
    public String deleteNote(@PathVariable("id") String id, Model model) {
        noteService.deleteNoteById(id);
        return "redirect:/web/note/list";
    }



}
