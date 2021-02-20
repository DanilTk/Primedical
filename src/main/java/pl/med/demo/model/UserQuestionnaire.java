package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class UserQuestionnaire {
    private Gender gender;
    private int age;
    private int weight;
    private int height;
    private double activityHours;
    private SmokingQuestionnaire smokingQuestionnaire;
    private Set<Condition> conditions;
    private Set<FamilyCondition> familyConditions;
    private Set<ExceptionMessage> exceptionMessages;
}
