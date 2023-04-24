package com.openclassrooms.mediscreenPatient.controller;

import com.google.gson.Gson;
import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/patients")
    public String getPatients() {
        List<Patient> listPatients = patientService.getAllPatients();
        String json = new Gson().toJson(listPatients);
        return json;
    }

    @GetMapping("/patient")
    public String getPatientById(@RequestParam(name = "patientId") int patientId) {

        Optional<Patient> patientById = patientService.getPatientById(patientId);
        String json = new Gson().toJson(patientById.get());
        return json;
    }

    @PostMapping("/patient")
    public Patient postPatient(@RequestBody Patient patient) {
        patientService.addPatient(patient);
        return patient;
    }


    @PutMapping("/patient")
    public Patient updatePatient(@RequestBody Patient patient) {
        patientService.updatePatient(patient);
        return patient;
    }


    @DeleteMapping("/patient")
    public void deletePersonById(@RequestParam(name = "patientId") int patientId) {
        patientService.deletePatientById(patientId);
    }

}

