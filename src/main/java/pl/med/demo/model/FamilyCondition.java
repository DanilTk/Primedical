package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FamilyCondition {
    private RelationshipLevel relationshipLevel;
    private int ageOfConditionDetection;
    private Condition conditions;
}
