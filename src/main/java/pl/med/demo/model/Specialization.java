package pl.med.demo.model;

public enum Specialization {
    GP("General Practitioner");

    private final String specialization;

    Specialization(String specialization) {
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }
}
