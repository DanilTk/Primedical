package pl.med.demo.service.screening_programs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.ScreeningType;
import pl.med.demo.model.UserQuestionnaire;

import java.util.Set;

import static pl.med.demo.model.ConditionName.*;

@Service
@RequiredArgsConstructor
public class HypertensionScreening implements Screening, RiskGroupScreening {
    private static final Set<ConditionName> RISK_FACTORS = Set.of(DIABETES, CVD, HIGH_CHOLESTEROL);

    @Override
    public Prescription performScreening(UserQuestionnaire userQuestionnaire) {
        boolean isHealthy = true;
        double bmi = calculateBMI(userQuestionnaire.getWeight(), userQuestionnaire.getHeight());
        int riskScore = calculateRiskFactorScore(userQuestionnaire.getConditions(), RISK_FACTORS);

        if (userQuestionnaire.getActivityHours() < 0.5) {
            riskScore = riskScore + 1;
        }

        if (userQuestionnaire.getSmokingQuestionnaire().isSmoker()) {
            riskScore = riskScore + 1;
        }

        if (userQuestionnaire.getAge() > 19 && userQuestionnaire.getAge() <= 39) {
            isHealthy = false;
        } else if (userQuestionnaire.getAge() > 40) {
            isHealthy = false;
        } else if (isInRiskGroup(bmi, riskScore, 1)) {
            isHealthy = false;
        } else if (calculateRiskFactorScore(userQuestionnaire.getConditions(), Set.of(HYPERTENSION)) == 1) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder()
                    .isHealthy(false)
                    .relevanceNote("High blood pressure is a major contributing risk factor for heart failure, heart attack, stroke, and chronic kidney disease. You should check your blood pressure from time to time to start treatment on time.")
                    .screeningType(ScreeningType.HYPERTENSION_SCREENING)
                    .build();
        }
    }
}
