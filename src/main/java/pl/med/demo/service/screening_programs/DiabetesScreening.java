package pl.med.demo.service.screening_programs;

import org.springframework.stereotype.Service;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserProfile;

import java.util.Set;

import static pl.med.demo.model.ConditionName.*;

@Service
public class DiabetesScreening implements Screening, RiskGroupScreening {
    private static final Set<ConditionName> RISK_FACTORS = Set.of(HYPERTENSION, CVD, HIGH_CHOLESTEROL, PCO);

    @Override
    public Prescription performScreening(UserProfile userProfile) {
        boolean isHealthy = true;
        double bmi = calculateBMI(userProfile.getWeight(), userProfile.getHeight());
        int riskScore = calculateRiskFactorScore(userProfile.getConditions(), RISK_FACTORS);

        if (userProfile.getActivityHours() < 0.5) {
            riskScore = riskScore + 1;
        }

        if (userProfile.getAge() <= 19 && isInRiskGroup(bmi, riskScore, 2)) {
            isHealthy = false;
        } else if (userProfile.getAge() > 19 && userProfile.getAge() <= 44 && isInRiskGroup(bmi, riskScore, 1)) {
            isHealthy = false;
        } else if (userProfile.getAge() > 44) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder() //todo: add visit list
                    .isHealthy(false)
                    .relevanceNote("According to American Diabetes Association you are in a group of an increased risk of having Diabetes Mellitus.  Early detection can greatly improve outcomes.\n \n Diabetes is a major cause of blindness, kidney failure, heart attacks, stroke and lower limb amputation. ")
                    .prescriptionNote("Conduct fasting plasma glucose test")
                    .build();
        }
    }
}
