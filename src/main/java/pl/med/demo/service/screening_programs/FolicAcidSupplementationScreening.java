package pl.med.demo.service.screening_programs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.Gender;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.ScreeningType;
import pl.med.demo.model.UserQuestionnaire;

@Service
@RequiredArgsConstructor
public class FolicAcidSupplementationScreening implements Screening {

    @Override
    public Prescription performScreening(UserQuestionnaire userQuestionnaire) {
        boolean isHealthy = true;
        int age = userQuestionnaire.getAge();

        if (age > 25 && age <= 45 && userQuestionnaire.getGender().equals(Gender.F)) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder()
                    .isHealthy(false)
                    .relevanceNote("Daily folic acid supplementation in the periconceptional period can prevent neural tube defects.\n" +
                            "\n" +
                            "Studies show that up to half of all pregnancies are unplanned. Therefore, clinicians advise all women who are capable of pregnancy to take daily folic acid supplements. The critical period for supplementation starts at least 1 month before conception and continues through the first 2 to 3 months of pregnancy.")
                    .screeningType(ScreeningType.FOLIC_ACID_SUPPLEMENTATION)
                    .build();
        }
    }
}
