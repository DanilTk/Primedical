package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class UserProfile {
    private Gender gender;
    private int age;
    private int weight;
    private int height;
    private double activityHours;
    private SmokerProfile smokerProfile;
    private Set<Condition> conditions;
    private Set<FamilyCondition> familyCondition;
}
