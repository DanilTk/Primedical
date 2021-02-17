package pl.med.demo.service.screening_programs;

import org.springframework.stereotype.Service;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserProfile;

import java.util.Set;

import static pl.med.demo.model.ConditionName.*;

@Service
public class HypertensionScreening implements Screening, RiskGroupScreening {
    private static final Set<ConditionName> RISK_FACTORS = Set.of(DIABETES, CVD, HIGH_CHOLESTEROL);

    @Override
    public Prescription performScreening(UserProfile userProfile) {
        boolean isHealthy = true;
        double bmi = calculateBMI(userProfile.getWeight(), userProfile.getHeight());
        int riskScore = calculateRiskFactorScore(userProfile.getConditions(), RISK_FACTORS);

        if (userProfile.getActivityHours() < 0.5) {
            riskScore = riskScore + 1;
        }

        if (userProfile.getSmokerProfile().isSmoker()) {
            riskScore = riskScore + 1;
        }

        if (userProfile.getAge() > 19 && userProfile.getAge() <= 39) {
            isHealthy = false;
        } else if (userProfile.getAge() > 40) {
            isHealthy = false;
        } else if (isInRiskGroup(bmi, riskScore, 1)) {
            isHealthy = false;
        } else if (calculateRiskFactorScore(userProfile.getConditions(), Set.of(HYPERTENSION)) == 1) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder() //todo: add visit list
                    .isHealthy(false)
                    .relevanceNote("High blood pressure is a major contributing risk factor for heart failure, heart attack, stroke, and chronic kidney disease. You should check your blood pressure from time to time to start treatment on time.")
                    .prescriptionNote("Visit general practitioner")
                    .build();
        }
    }
}
