package pl.med.demo.service.screening_programs;

import org.springframework.stereotype.Service;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.Gender;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserProfile;

import java.util.Set;

import static pl.med.demo.model.ConditionName.CVD;

@Service
public class CholesterolScreening implements Screening {
    private final Set<ConditionName> riskFactors = Set.of(CVD);

    @Override
    public Prescription performScreening(UserProfile userProfile) {
        int riskScore = calculateRiskFactorScore(userProfile.getConditions(), riskFactors);

        if (userProfile.getAge() > 10 && userProfile.getAge() <= 45) {
            return Prescription.builder()
                    .isHealthy(false)
                    .build();
        } else if (userProfile.getAge() > 45 && userProfile.getGender() == Gender.M) {
            return Prescription.builder()
                    .isHealthy(false)
                    .build();
        } else if (userProfile.getAge() > 55 && userProfile.getGender() == Gender.F) {
            return Prescription.builder()
                    .isHealthy(false)
                    .build();
        } else if (userProfile.getAge() > 65 || riskScore > 0) {
            return Prescription.builder()
                    .isHealthy(false)
                    .build();
        }

        return Prescription.builder()
                .isHealthy(true)
                .build();
    }
}
