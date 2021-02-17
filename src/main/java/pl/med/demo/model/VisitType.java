package pl.med.demo.model;

public enum VisitType {
    SCREENING("Screening"),
    LAB_TEST("Laboratory test");

    private final String type;

    VisitType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
