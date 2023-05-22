package com.openclassrooms.mediscreenDiabet.beans;
import com.openclassrooms.mediscreenDiabet.constants.RiskLevel;
import java.util.List;

public class AssessDTO {

    private PatientBean patient;
    private List<NoteBean> notes;
    private int age;
    private RiskLevel riskLevel;

    public PatientBean getPatient() {
        return patient;
    }

    public void setPatient(PatientBean patient) {
        this.patient = patient;
    }

    public List<NoteBean> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteBean> notes) {
        this.notes = notes;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }
}
