package com.openclassrooms.mediscreenDiabet.proxies;

import com.openclassrooms.mediscreenDiabet.beans.PatientBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "mediscreenPatient", url = "localhost:8081")
public interface MediscreenPatientProxy {

    @GetMapping("/patients")
    List<PatientBean> getPatients();

    @GetMapping("/patient/{id}")
    PatientBean getPatientById(@PathVariable(name = "id") int patientId);

    @GetMapping("/patient")
    List<PatientBean> getPatientByFamily(@RequestParam(name = "family") String family);




}
