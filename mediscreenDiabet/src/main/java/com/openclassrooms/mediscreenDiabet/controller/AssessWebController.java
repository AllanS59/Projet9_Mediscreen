package com.openclassrooms.mediscreenDiabet.controller;

import com.openclassrooms.mediscreenDiabet.beans.AssessDTO;
import com.openclassrooms.mediscreenDiabet.service.AssessDTOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AssessWebController {

    @Autowired
    AssessDTOService assessDTOService;

    @RequestMapping("/web/assess/{id}")
    public String listPatient(@PathVariable("id") Integer id, Model model) {
        AssessDTO assessDTO = assessDTOService.createAssessDTOById(id);
        model.addAttribute("assessDTO", assessDTO);
        return "assessById";
    }



}
