package com.openclassrooms.mediscreenDiabet.controller;

import com.openclassrooms.mediscreenDiabet.beans.PatientBean;
import com.openclassrooms.mediscreenDiabet.service.AssessService;
import com.openclassrooms.mediscreenDiabet.service.PatientBeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class AssessController {

    @Autowired
    private AssessService assessService;

    @Autowired
    private PatientBeanService patientBeanService;



    @GetMapping("/assess/{id}")
    public String getAssessById(@PathVariable(name = "id") int id) {

        PatientBean patient = patientBeanService.getPatientById(id) ;
        return assessService.assessDiabetStatement(patient);

    }

    @GetMapping("/assess")
    public List<String> getAssessByName(@RequestParam(name = "patientName") String patientName) {

        List<String> listAssess = new ArrayList<>();
        List<PatientBean> patients = patientBeanService.getPatientByFamily(patientName) ;

        for (PatientBean p : patients){
            listAssess.add(assessService.assessDiabetStatement(p));
        }

        return listAssess;

    }
}
