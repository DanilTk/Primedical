package pl.med.demo.model;

public enum ScreeningType {
    CHOLESTEROL_SCREENING("Cholesterol Screening"),
    DIABETES_SCREENING("Diabetes Screening"),
    COLONOSCOPY("Colonoscopy Screening"),
    FECAL_OCCULT_BLOOD_TEST("Fecal occult blood test"),
    HYPERTENSION_SCREENING("Hypertension Screening");

    private final String screeningName;

    ScreeningType(String screeningName) {
        this.screeningName = screeningName;
    }

    public String getScreeningName() {
        return screeningName;
    }
}
