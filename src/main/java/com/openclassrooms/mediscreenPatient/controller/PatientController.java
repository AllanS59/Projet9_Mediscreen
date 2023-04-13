package com.openclassrooms.mediscreenPatient.controller;

import com.openclassrooms.mediscreenPatient.model.Patient;
import com.openclassrooms.mediscreenPatient.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import javax.validation.Valid;

@Controller
public class PatientController {

    @Autowired
    private PatientService patientService;


    @RequestMapping("/patient/list")
    public String home(Model model) {
        List<Patient> listPatients = patientService.getAllPatients();
        model.addAttribute("listPatients", listPatients);
        return "patientList";
    }


    @GetMapping("/patient/add")
    public String addpatientForm(Patient patient) {
        return "patientAdd";
    }

    @PostMapping("/patient/validate")
    public String validate(@Valid @DateTimeFormat(pattern= "yyyy-MM-dd") Patient patient, BindingResult result, Model model) {
        // If no errors in data provided by user, save data and go back to 'list' page
        if (!result.hasErrors()) {
            patientService.addPatient(patient);
            List<Patient> listPatients = patientService.getAllPatients();
            model.addAttribute("listPatients", listPatients);
            return "redirect:/patient/list";
        }
        // else stay on the current page
        return "patientAdd";
    }


    @GetMapping("/patient/update/{id}")
    public String showUpdateForm(@PathVariable("id") Integer id, Model model) {
        Patient patient = patientService.getPatientById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Patient Id:" + id));
        model.addAttribute("patient", patient);
        return "patientUpdate";
    }


    @PostMapping("/patient/update/{id}")
    public String updatePatient(@PathVariable("id") Integer id, @Valid Patient patient, BindingResult result, Model model) {
        // If errors in data provided by user, stay on current page
        if (result.hasErrors()) {
            return "patientUpdate";
        }
        // If no error, save data into database and go back to 'List' page
        patient.setPatientId(id);
        patientService.addPatient(patient);
        List<Patient> listPatients = patientService.getAllPatients();
        model.addAttribute("listPatients", listPatients);
        return "redirect:/patient/list";
    }



    @GetMapping("/patient/delete/{id}")
    public String deletePatient(@PathVariable("id") Integer id, Model model) {
        patientService.deletePatientById(id);
        return "redirect:/patient/list";
    }

}
