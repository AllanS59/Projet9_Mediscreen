package com.openclassrooms.mediscreenPatient.service;

import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;


    /**
     * GET all Patients from database
     * @return List<Patient> list of all patients.
     */
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }

    /**
     * GET a patient by Id from database, if exists
     * @param patientId the Id of the patient to find
     * @return Optional<Patient> patient found if any.
     */
    public Optional<Patient> getPatientById(int patientId) {
        return patientRepository.findById(patientId);
    }

    /**
     * GET list of patients by family (family name)
     * @param family the family name of patients to find
     * @return List<Patient> list of patients by family name.
     */
    public List<Patient> getPatientByFamily (String family){
        return patientRepository.findByFamily(family);
    }

    /**
     * GET list of patients by family (family name) AND given (surname)
     * @param family the family name of patients to find
     * @param given the surname of patients to find
     * @return List<Patient> list of patients by family name and surname
     */
    public List<Patient> getPatientByFamilyAndGiven (String family , String given){
        return patientRepository.findByFamilyAndGiven(family, given);
    }

    /**
     * POST a new patient into database
     * @param patient the patient to save in database
     * @return patient the patient to save in database
     */
    public Patient addPatient (Patient patient){
        patientRepository.save(patient);
        return patient;
    }

    /**
     * UPDATE a new patient into database
     * @param patient the patient to update in database
     * @return patient the patient to update in database
     */
    public Patient updatePatient (Patient patient){
        patientRepository.save(patient);
        return patient;
    }

    /**
     * DELETE a patient by Id
     * @param patientId the ID of the patient to delete
     */
    public void deletePatientById (int patientId){
        patientRepository.deleteById(patientId);
    }

}
