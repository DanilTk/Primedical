package pl.med.demo.service.screening_programs;

import pl.med.demo.model.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface Screening {

    Prescription performScreening(UserQuestionnaire userQuestionnaire);

    default double calculateBMI(int weight, int height) {
        return weight / Math.pow(height, 2) * 10000;
    }

    default int calculateConditionNameRiskFactorScore(Set<Condition> conditions, Set<ConditionName> riskFactors) {
        return conditions.stream()
                .map(Condition::getName)
                .filter(riskFactors::contains)
                .collect(Collectors.toSet())
                .size();
    }

    default boolean isConditionPresentInFamily(Condition condition, Set<FamilyCondition> familyConditions) {
        Set<Condition> familyConditionsSet = familyConditions.stream()
                .flatMap(familyCondition -> Stream.of(familyCondition.getConditions()))
                .collect(Collectors.toSet());

        return familyConditionsSet.contains(condition);
    }

    default Prescription confirmIsHealthy() {
        return Prescription.builder()
                .isHealthy(true)
                .build();
    }
}
