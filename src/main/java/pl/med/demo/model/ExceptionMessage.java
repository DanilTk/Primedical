package pl.med.demo.model;

public enum ExceptionMessage {
    INVALID_AGE("Age must be between 18 and 99"),
    INVALID_WEIGHT("Weight must be between 30 and 300 kg"),
    INVALID_HEIGHT("Weight must be between 120 and 250 cm"),
    INVALID_YEARS_SMOKED("Years smoked cannot exceed age"),
    INVALID_DIAGNOSIS_AGE("Diagnosed disease age must be between 1 and 100");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
