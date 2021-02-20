package pl.med.demo.service.screening_programs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Gender;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserQuestionnaire;

import java.util.Set;

import static pl.med.demo.model.ConditionName.CVD;

@Service
@RequiredArgsConstructor
public class CholesterolScreening implements Screening {
    private static final Set<ConditionName> RISK_FACTORS = Set.of(CVD);
    private final VisitBuilder visitBuilder;

    @Override
    public Prescription performScreening(UserQuestionnaire userQuestionnaire) {
        boolean isHealthy = true;
        int riskScore = calculateRiskFactorScore(userQuestionnaire.getConditions(), RISK_FACTORS);

        if (userQuestionnaire.getAge() > 10 && userQuestionnaire.getAge() <= 45) {
            isHealthy = false;
        } else if (userQuestionnaire.getAge() > 45 && userQuestionnaire.getGender() == Gender.M) {
            isHealthy = false;
        } else if (userQuestionnaire.getAge() > 55 && userQuestionnaire.getGender() == Gender.F) {
            isHealthy = false;
        } else if (userQuestionnaire.getAge() > 65 || riskScore > 0) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder()
                    .isHealthy(false)
                    .relevanceNote("Dyslipidemia occurs when there are abnormal amounts of lipids (e.g., cholesterol and/or fat) in the blood. This condition is a major risk factor for developing cardiovascular disease (CVD), which is the leading cause of death among men and women worldwide. These tests will be used by your GP to assess the need to start you on medications called statins based on calculated risk of a cardiovascular event(ACC/AHA or SCORE).")
                    .prescriptionNote("Conduct fasting plasma glucose test")
                    .visit(visitBuilder.buildCholesterolVisits())
                    .build();
        }
    }
}
