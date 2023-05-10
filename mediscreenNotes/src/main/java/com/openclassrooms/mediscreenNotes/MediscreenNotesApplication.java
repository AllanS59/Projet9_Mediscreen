package com.openclassrooms.mediscreenNotes;

import com.openclassrooms.mediscreenNotes.model.Note;
import com.openclassrooms.mediscreenNotes.repository.InitialNoteDataCreator;
import com.openclassrooms.mediscreenNotes.repository.NoteRepository;
import com.openclassrooms.mediscreenNotes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class MediscreenNotesApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(MediscreenNotesApplication.class, args);
	}

//	@Autowired
//	private NoteService noteService;


	@Override
	public void run(String... args) throws Exception {
			System.out.println("Application started");

//		List<Note> noteByPatId = noteService.getNoteByPatient(2);
//		System.out.println(noteByPatId.size());
//		System.out.println(noteService.getNoteByPatient(noteByPatId.get(0).getPatient()));
	}
}
