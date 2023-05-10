package com.openclassrooms.mediscreenDiabet.constants;

public enum RiskLevel {
    NONE ("None"),
    BORDERLINE ("Borderline"),
    IN_DANGER ("In Danger"),
    EARLY_ONSET ("Early Onset");

    private String level;

    RiskLevel(String level) {
        this.level = level;
    }

    public String getLevelInString() {
        return level;
    }
}
