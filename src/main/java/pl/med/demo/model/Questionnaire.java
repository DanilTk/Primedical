package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Questionnaire {
    private Gender gender;
    private int age;
    private int weight;
    private int height;
    private SmokerProfile smokerProfile;
    private Set<Condition> conditions;
    private Set<FamilyCondition> familyCondition;
}
