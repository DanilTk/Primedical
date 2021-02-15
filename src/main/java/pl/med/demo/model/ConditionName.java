package pl.med.demo.model;

public enum ConditionName {
    DIABETES("Diabetes"),
    HYPERTENSION("Hypertension"),
    CVD("Cvd"),
    HIGH_CHOLESTEROL("High_cholesterol"),
    THYROID_DISEASE("Thyroid_disease"),
    HEPATITIS("Hepatitis"),
    PCO("Pco"),
    CANCER("Cancer");

    private final String conditionName;

    ConditionName(String conditionName) {
        this.conditionName = conditionName;
    }

    public String getConditionName() {
        return conditionName;
    }
}
