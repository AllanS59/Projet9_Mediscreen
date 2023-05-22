package com.openclassrooms.mediscreenDiabet.service;

import com.openclassrooms.mediscreenDiabet.beans.AssessDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssessDTOService {

    @Autowired
    public AssessService assessService;

    @Autowired
    public PatientBeanService patientService;

    @Autowired
    public NoteBeanService noteService;



    public AssessDTO createAssessDTOById (int patId){

        AssessDTO assessDTO = new AssessDTO();
        assessDTO.setPatient(patientService.getPatientById(patId));
        assessDTO.setNotes(noteService.getNoteByPatient(patId));
        assessDTO.setAge(assessService.getPatientAge(assessDTO.getPatient()));
        assessDTO.setRiskLevel(assessService.estimateRiskLevelOfPatient(assessDTO.getPatient()));

        return assessDTO;
    }
}
