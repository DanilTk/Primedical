package pl.med.demo.model;

public enum RelationshipLevel {
    PARENT("Parent"),
    SIBLING("Sibling"),
    CHILD("Child");

    private final String relationship;

    RelationshipLevel(String relationship) {
        this.relationship = relationship;
    }

    public String getRelationship() {
        return relationship;
    }
}
