package com.openclassrooms.mediscreenPatient.repository;

import com.openclassrooms.mediscreenPatient.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    List<Patient> findByFamily(String family);
    List<Patient> findByFamilyAndGiven (String family, String given);
}


