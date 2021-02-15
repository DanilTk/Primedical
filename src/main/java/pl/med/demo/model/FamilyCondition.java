package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class FamilyCondition {
    private RelationshipLevel relationshipLevel;
    private int ageOfConditionDetection;
    private Set<Condition> conditions;
}
