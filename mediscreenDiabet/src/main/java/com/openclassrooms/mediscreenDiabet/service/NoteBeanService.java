package com.openclassrooms.mediscreenDiabet.service;

import com.openclassrooms.mediscreenDiabet.beans.NoteBean;
import com.openclassrooms.mediscreenDiabet.proxies.MediscreenNotesProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteBeanService {

    @Autowired
    private MediscreenNotesProxy mediscreenNotesProxy;

    /**
     * GET all Notes from database
     * @return List<NoteBean> list of all notes.
     */
    public List<NoteBean> getAllNotes(){
        return mediscreenNotesProxy.getNotes();
    }

    /**
     * GET a note by note Id from database, if exists
     * @param id the note Id of the note to find
     * @return NoteBean note found if any.
     */
    public NoteBean getNoteById(String id) {
        return mediscreenNotesProxy.getNoteById(id);
    }


    /**
     * GET a note by patient ID from database, if exists
     * @param patientId the name of the patient
     * @return List<NoteBean> notes found if any.
     */
    public List<NoteBean> getNoteByPatient(int patientId) {
        return mediscreenNotesProxy.getNoteByPatId(patientId);
    }


    /**
     * Extract a list of practitionner's notes(string) from a list of NoteBean object
     * @param notes the name of the NoteBean list
     * @return List<String> list of practitionner's notes(string) .
     */
    public List<String> extractNotesStringfromNote(List<NoteBean> notes) {

        List<String> notesString = new ArrayList<>();
        for(NoteBean n : notes){
            notesString.add(n.getNote());
        }
        return notesString;
    }
}
