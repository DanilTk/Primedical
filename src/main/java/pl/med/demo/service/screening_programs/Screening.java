package pl.med.demo.service.screening_programs;

import pl.med.demo.model.Condition;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserQuestionnaire;

import java.util.Set;
import java.util.stream.Collectors;

public interface Screening {

    Prescription performScreening(UserQuestionnaire userQuestionnaire);

    default double calculateBMI(int weight, int height) {
        return weight / Math.pow(height, 2) * 10000;
    }

    default int calculateRiskFactorScore(Set<Condition> conditions, Set<ConditionName> riskFactors) {
        return conditions.stream()
                .map(Condition::getName)
                .filter(riskFactors::contains)
                .collect(Collectors.toSet())
                .size();
    }

    default Prescription confirmIsHealthy() {
        return Prescription.builder()
                .isHealthy(true)
                .build();
    }
}
