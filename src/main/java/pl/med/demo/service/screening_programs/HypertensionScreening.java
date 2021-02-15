package pl.med.demo.service.screening_programs;

import org.springframework.stereotype.Service;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserProfile;

import java.util.Set;

import static pl.med.demo.model.ConditionName.*;

@Service
public class HypertensionScreening implements Screening {
    private final Set<ConditionName> riskFactors = Set.of(DIABETES, CVD, HIGH_CHOLESTEROL);

    @Override
    public Prescription performScreening(UserProfile userProfile) {
        double bmi = calculateBMI(userProfile.getWeight(), userProfile.getHeight());
        int riskScore = calculateRiskFactorScore(userProfile.getConditions(), riskFactors);

        if (userProfile.getActivityHours() < 0.5) {
            riskScore = riskScore++;
        }

        if (userProfile.getSmokerProfile().isSmoker()) {
            riskScore = riskScore++;
        }

        if (userProfile.getAge() > 19 && userProfile.getAge() <= 39) {
            return Prescription.builder()
                    .isHealthy(false)
                    .build();
        } else if (userProfile.getAge() > 40) {
            return Prescription.builder()
                    .isHealthy(false)
                    .build();
        } else if (isInRiskGroup(bmi, riskScore, 1)) {
            return Prescription.builder()
                    .isHealthy(false)
                    .build();
        } else if (calculateRiskFactorScore(userProfile.getConditions(), Set.of(HYPERTENSION)) == 1) {
            return Prescription.builder()
                    .isHealthy(false)
                    .build();
        }

        return Prescription.builder()
                .isHealthy(true)
                .build();
    }

    private boolean isInRiskGroup(double bmi, int riskFactorScore, int riskFactorThreshold) {
        return bmi >= 25 && riskFactorScore >= riskFactorThreshold;
    }
}
