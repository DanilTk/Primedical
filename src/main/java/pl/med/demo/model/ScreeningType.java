package pl.med.demo.model;

public enum ScreeningType {
    CHOLESTEROL_SCREENING("Cholesterol Screening"),
    DIABETES_SCREENING("Diabetes Screening"),
    HYPERTENSION_SCREENING("Hypertension Screening");

    private final String screeningName;

    ScreeningType(String screeningName) {
        this.screeningName = screeningName;
    }

    public String getScreeningName() {
        return screeningName;
    }
}
