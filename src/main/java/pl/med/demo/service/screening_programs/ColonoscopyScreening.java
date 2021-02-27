package pl.med.demo.service.screening_programs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.*;

@Service
@RequiredArgsConstructor
public class ColonoscopyScreening implements Screening {
    private static final Condition condition = new Condition(ConditionName.CANCER, ConditionType.COLORECTAL);

    @Override
    public Prescription performScreening(UserQuestionnaire userQuestionnaire) {
        boolean isHealthy = true;
        int age = userQuestionnaire.getAge();

        if (age > 40 && age <= 49 && isConditionPresentInFamily(condition, userQuestionnaire.getFamilyConditions())) {
            isHealthy = false;
        } else if (age > 50 && age <= 64) {
            isHealthy = false;
        }

        if (!isHealthy) {
            return Prescription.builder()
                    .isHealthy(false)
                    .relevanceNote("Colorectal cancer almost always develops from precancerous polyps (abnormal growths) in the colon or rectum. Screening tests can find precancerous polyps, so that they can be removed before they turn into cancer. The vast majority of new cases of colorectal cancer (about 90%) occur in people who are 50 or older.")
                    .screeningType(ScreeningType.COLONOSCOPY)
                    .build();
        }

        if (age > 50) {
            isHealthy = false;
        } else if (age > 40 && isConditionPresentInFamily(condition, userQuestionnaire.getFamilyConditions())) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder()
                    .isHealthy(false)
                    .relevanceNote("Colorectal cancer almost always develops from precancerous polyps (abnormal growths) in the colon or rectum. Screening tests can find precancerous polyps, so that they can be removed before they turn into cancer. The vast majority of new cases of colorectal cancer (about 90%) occur in people who are 50 or older.")
                    .screeningType(ScreeningType.FECAL_OCCULT_BLOOD_TEST)
                    .build();
        }
    }
}

