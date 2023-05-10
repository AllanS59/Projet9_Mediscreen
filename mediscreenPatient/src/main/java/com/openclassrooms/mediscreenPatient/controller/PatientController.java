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
    public List<Patient> getPatients() {
        List<Patient> listPatients = patientService.getAllPatients();
        return listPatients;
    }


    @GetMapping("/patient/{id}")
    public Patient getPatientById(@PathVariable(name = "id") int patientId) {

        Optional<Patient> patientById = patientService.getPatientById(patientId);
        if(patientById.isPresent()){
            return patientById.get();
        }
        else {
            return null;
        }
    }

    @GetMapping("/patient")
    public List<Patient> getPatientByFamily(@RequestParam(name = "family") String family) {

        List<Patient> patientsByFamily = patientService.getPatientByFamily(family);
        return patientsByFamily;

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


    @DeleteMapping("/patient/{id}")
    public void deletePersonById(@PathVariable(name = "id") int patientId) {
        patientService.deletePatientById(patientId);
    }

}

