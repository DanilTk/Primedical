package pl.med.demo.model;

public enum ScreeningType {
    CERVICAL_SMEAR_SCREENING("Cervical Smear Screening"),
    CHOLESTEROL_SCREENING("Cholesterol Screening"),
    DIABETES_SCREENING("Diabetes Screening"),
    COLONOSCOPY("Colonoscopy Screening"),
    FECAL_OCCULT_BLOOD_TEST("Fecal Occult Blood Test"),
    HYPERTENSION_SCREENING("Hypertension Screening"),
    HIV_INFECTION_TEST("HIV Test"),
    FOLIC_ACID_SUPPLEMENTATION("Folic acid supplementation");

    private final String screeningName;

    ScreeningType(String screeningName) {
        this.screeningName = screeningName;
    }
}
