package pl.med.demo.model;

public enum ConditionType {
    NA("N/A"),
    TYPE_1("Type 1"),
    TYPE_2("Type 2"),
    TYPE_3("Type 3"),
    BLADDER("Bladder"),
    BREAST("Breast"),
    CERVICAL("Cervical"),
    COLORECTAL("Colorectal"),
    KIDNEY("Kidney"),
    MELANOMA("Melanoma"),
    LEUKEMIA("Leukemia"),
    LIVER_BILE_DUCTS("Liver/Bile ducts"),
    LUNG("Lung"),
    LYMPHOMA("Lymphoma"),
    THYROID("Thyroid"),
    OVARIAN("Ovarian"),
    PANCREATIC("Pancreatic"),
    PROSTATE("Prostate"),
    TESTICULAR("Testicular"),
    UTERINE("Uterine");

    private final String conditionType;

    ConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getConditionType() {
        return conditionType;
    }
}
