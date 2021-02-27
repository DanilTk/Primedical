package pl.med.demo.model;

public enum ScreeningType {
    CERVICAL_SMEAR_SCREENING("Cervical Smear Screening"),
    CHOLESTEROL_SCREENING("Cholesterol Screening"),
    DIABETES_SCREENING("Diabetes Screening"),
    COLONOSCOPY("Colonoscopy Screening"),
    FECAL_OCCULT_BLOOD_TEST("Fecal Occult Blood Test"),
    HYPERTENSION_SCREENING("Hypertension Screening");

    private final String screeningName;

    ScreeningType(String screeningName) {
        this.screeningName = screeningName;
    }

    public String getScreeningName() {
        return screeningName;
    }
}
