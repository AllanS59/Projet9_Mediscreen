package com.openclassrooms.mediscreenDiabet.mediscreenDiabet.service;

import com.openclassrooms.mediscreenDiabet.beans.PatientBean;
import com.openclassrooms.mediscreenDiabet.constants.RiskLevel;
import com.openclassrooms.mediscreenDiabet.service.AssessService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AssessServiceTest {

    @Autowired
    AssessService assessService;

    @Test
    public void getPatientAgeTest() throws ParseException {

        String dateString = "1992-12-12";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        PatientBean patient = new PatientBean();
        patient.setFamily("Family Test");
        patient.setDob(date);

        int patientAge = assessService.getPatientAge(patient);

        assertEquals(30, patientAge);
    }


    @Test
    public void isKeyWordPresentInListTestWhenOk() throws ParseException {

       List<String> listString = new ArrayList<>();
       listString.add("There is not the word here");
       listString.add("not here");
       listString.add("the word Test is here");
       listString.add("end of list");

       String keyword = "test";

        assertEquals(true, assessService.isKeyWordPresentInList(keyword, listString));
    }

    @Test
    public void isKeyWordPresentInListTestWhenNotOk()  {

        List<String> listString = new ArrayList<>();
        listString.add("There is not the word here");
        listString.add("not here");
        listString.add("end of list");

        String keyword = "test";

        assertEquals(false, assessService.isKeyWordPresentInList(keyword, listString));
    }


    @Test
    public void countKeyWordsInNotesForPatientByIdTest() {
        int keyword1 = assessService.countKeyWordsInNotesForPatientById(1);
        int keyword2 = assessService.countKeyWordsInNotesForPatientById(2);
        int keyword3 = assessService.countKeyWordsInNotesForPatientById(3);
        int keyword4 = assessService.countKeyWordsInNotesForPatientById(4);

        assertEquals(1, keyword1);
        assertEquals(2, keyword2);
        assertEquals(3, keyword3);
        assertEquals(8, keyword4);

    }

    @Test
    public void estimateRiskLevelOfPatientTest() throws ParseException {
        PatientBean patient = new PatientBean();
        String dateString = "2002-06-28";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        patient.setPatientId(4);
        patient.setDob(date);
        patient.setSex("F");


        RiskLevel level = assessService.estimateRiskLevelOfPatient(patient);
        assertEquals(RiskLevel.EARLY_ONSET, level);
    }

    @Test
    public void assessDiabetStatementTest() throws ParseException {

        PatientBean patient = new PatientBean();
        String dateString = "2004-12-18";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(dateString);

        patient.setPatientId(3);
        patient.setFamily("FamilyTest");
        patient.setGiven("GivenTest");
        patient.setDob(date);
        patient.setSex("M");

        String testString = assessService.assessDiabetStatement(patient);
        String targetString = "Patient: GivenTest FamilyTest (age 18) diabetes assessment is: In Danger";

        assertEquals(targetString, testString);

    }




}
