package pl.med.demo.service.screening_programs;

import org.springframework.stereotype.Service;
import pl.med.demo.model.Condition;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserProfile;

import java.util.Set;
import java.util.stream.Collectors;

import static pl.med.demo.model.ConditionName.*;

@Service
public class DiabetesScreening implements Screening {
    private final Set<ConditionName> conditionNames = Set.of(HYPERTENSION, CVD, HIGH_CHOLESTEROL, PCO);

    @Override
    public Prescription performScreening(UserProfile userProfile) {
        double bmi = calculateBMI(userProfile.getWeight(), userProfile.getHeight());
        int riskScore = calculateRiskScore(userProfile.getConditions(), userProfile.getActivityHours());
//todo: finalize prescription object params returned
        if (userProfile.getAge() <= 19 && isInRiskGroup(bmi, riskScore, 2)) {
            return Prescription.builder()
                    .note("TBD")
                    .build();
        } else if (userProfile.getAge() > 19 && userProfile.getAge() <= 44 && isInRiskGroup(bmi, riskScore, 1)) {
            return Prescription.builder()
                    .note("TBD")
                    .build();
        } else if (userProfile.getAge() > 44) {
            return Prescription.builder()
                    .note("TBD")
                    .build();
        }

        return Prescription.builder()
                .isHealthy(true)
                .build();
    }

    private int calculateRiskScore(Set<Condition> conditions, double activityHours) {
        int riskScore = conditions.stream()
                .map(Condition::getName)
                .filter(conditionNames::contains)
                .collect(Collectors.toSet())
                .size();

        if (activityHours < 0.5) {
            riskScore = riskScore++;
        }

        return riskScore;
    }

    private boolean isInRiskGroup(double bmi, int riskFactorScore, int riskFactorThreshold) {
        return bmi >= 25 && riskFactorScore >= riskFactorThreshold;
    }

    private double calculateBMI(int weight, int height) {
        return weight / Math.pow(height, 2);
    }
}
