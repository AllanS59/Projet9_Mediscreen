package com.openclassrooms.mediscreenDiabet.controller;

import com.openclassrooms.mediscreenDiabet.service.AssessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AssessWebController {

    @Autowired
    private AssessService assessService;

    @RequestMapping("/web/assess/list")
    public String listPatient(Model model) {
       // List<Patient> listPatients = patientService.getAllPatients();
       // model.addAttribute("listPatients", listPatients);
        return "assessById";
    }



}
