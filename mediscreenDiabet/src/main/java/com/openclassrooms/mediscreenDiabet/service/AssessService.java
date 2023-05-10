package com.openclassrooms.mediscreenDiabet.service;

import com.openclassrooms.mediscreenDiabet.beans.NoteBean;
import com.openclassrooms.mediscreenDiabet.beans.PatientBean;
import com.openclassrooms.mediscreenDiabet.constants.Constants;
import com.openclassrooms.mediscreenDiabet.constants.RiskLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class AssessService {

    @Autowired
    private PatientBeanService patientBeanService;

    @Autowired
    private NoteBeanService noteBeanService;


   public int getPatientAge(PatientBean patient){
        Date todaysDate = new Date();

       // validate inputs ...
       DateFormat formatter = new SimpleDateFormat("yyyyMMdd");
       int d1 = Integer.parseInt(formatter.format(patient.getDob()));
       int d2 = Integer.parseInt(formatter.format(todaysDate));

       int age = (d2 - d1) / 10000;
       return age;
    }


    public boolean isKeyWordPresentInList (String keyword, List<String> notes){

      boolean keyWordFound = false;
        for (String note : notes) {
            if (note.toLowerCase().contains(keyword.toLowerCase())) {
                keyWordFound = true;
                break;
            }
        }
        return keyWordFound;
    }

    public int countKeyWordsInNotesForPatientById (int patientId){

       List<NoteBean> notesByPatId = noteBeanService.getNoteByPatient(patientId);
       List<String> NotesByPatIdString = noteBeanService.extractNotesStringfromNote(notesByPatId);

       int keywordCounter = 0;
       for (String keyword : Constants.KEYWORDS){
           if (isKeyWordPresentInList(keyword, NotesByPatIdString)){
               keywordCounter = keywordCounter + 1;
           }
       }
       return keywordCounter;
    }


    public RiskLevel estimateRiskLevelOfPatient (PatientBean patient) {
        RiskLevel riskLevel = RiskLevel.NONE;

       int patientAge = getPatientAge(patient);
       String patientSex = patient.getSex();
       int keywordsCount = countKeyWordsInNotesForPatientById(patient.getPatientId());

       if (keywordsCount==0){
           riskLevel = RiskLevel.NONE;
       }
       else if (patientAge > 30 && keywordsCount==2){
           riskLevel = RiskLevel.BORDERLINE;
       }
       else if ((patientAge <=30 && patientSex.equals("M") && keywordsCount>=3 && keywordsCount<5)
               || (patientAge <=30 && patientSex.equals("F") && keywordsCount>=4 && keywordsCount<7)
               || (patientAge >30 && keywordsCount>=6 && keywordsCount<8)){
           riskLevel = RiskLevel.IN_DANGER;
       }
       else if ((patientAge <=30 && patientSex.equals("M") && keywordsCount>=5)
               || (patientAge <=30 && patientSex.equals("F") && keywordsCount>=7)
               || (patientAge >30 && keywordsCount>=8)){
           riskLevel = RiskLevel.EARLY_ONSET;
       }


    return riskLevel;
    }


    public String assessDiabetStatement (PatientBean patient){

        int patientAge = getPatientAge(patient);
        RiskLevel riskLevel = estimateRiskLevelOfPatient(patient);

        String assess = "Patient: " + patient.getGiven() + " " + patient.getFamily() + " (age " + patientAge  +") diabetes assessment is: " + riskLevel.getLevelInString();
        return assess;
    }


}
