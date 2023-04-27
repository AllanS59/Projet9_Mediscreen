package com.openclassrooms.mediscreenNotes;

import com.openclassrooms.mediscreenNotes.model.Note;
import com.openclassrooms.mediscreenNotes.repository.NoteRepository;
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


	@Override
	public void run(String... args) throws Exception {
			System.out.println("Application started");
	}
}
