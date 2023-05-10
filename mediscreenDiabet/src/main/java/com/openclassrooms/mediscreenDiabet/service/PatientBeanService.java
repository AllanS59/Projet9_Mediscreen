package com.openclassrooms.mediscreenDiabet.service;


import com.openclassrooms.mediscreenDiabet.beans.PatientBean;
import com.openclassrooms.mediscreenDiabet.proxies.MediscreenPatientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientBeanService {

    @Autowired
    public MediscreenPatientProxy mediscreenPatientProxy;

    /**
     * GET all Patients from database
     * @return List<PatientBean> list of all patients.
     */
    public List<PatientBean> getAllPatients(){
        return mediscreenPatientProxy.getPatients();
    }


    /**
     * GET a patient by Id from database, if exists
     * @param patientId the Id of the patient to find
     * @return PatientBean patient found if any.
     */
    public PatientBean getPatientById(int patientId) {
        return mediscreenPatientProxy.getPatientById(patientId);
    }


    /**
     * GET a patient by Family Name from database, if exists
     * @param family the Family Name of the patient to find
     * @return List<PatientBean> patient found if any.
     */
    public List<PatientBean> getPatientByFamily(String family) {
        return mediscreenPatientProxy.getPatientByFamily(family);
    }
}
