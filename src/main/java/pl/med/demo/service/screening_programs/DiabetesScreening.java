package pl.med.demo.service.screening_programs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserQuestionnaire;

import java.util.Set;

import static pl.med.demo.model.ConditionName.*;

@Service
@RequiredArgsConstructor
public class DiabetesScreening implements Screening, RiskGroupScreening {
    private static final Set<ConditionName> RISK_FACTORS = Set.of(HYPERTENSION, CVD, HIGH_CHOLESTEROL, PCO);
    private final VisitBuilder visitBuilder;

    @Override
    public Prescription performScreening(UserQuestionnaire userQuestionnaire) {
        boolean isHealthy = true;
        double bmi = calculateBMI(userQuestionnaire.getWeight(), userQuestionnaire.getHeight());
        int riskScore = calculateRiskFactorScore(userQuestionnaire.getConditions(), RISK_FACTORS);

        if (userQuestionnaire.getActivityHours() < 0.5) {
            riskScore = riskScore + 1;
        }

        if (userQuestionnaire.getAge() <= 19 && isInRiskGroup(bmi, riskScore, 2)) {
            isHealthy = false;
        } else if (userQuestionnaire.getAge() > 19 && userQuestionnaire.getAge() <= 44 && isInRiskGroup(bmi, riskScore, 1)) {
            isHealthy = false;
        } else if (userQuestionnaire.getAge() > 44) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder()
                    .isHealthy(false)
                    .relevanceNote("According to American Diabetes Association you are in a group of an increased risk of having Diabetes Mellitus.  Early detection can greatly improve outcomes.\n \n Diabetes is a major cause of blindness, kidney failure, heart attacks, stroke and lower limb amputation. ")
                    .prescriptionNote("Conduct fasting plasma glucose test")
                    .visit(visitBuilder.buildDiabetesVisits())
                    .build();
        }
    }
}
