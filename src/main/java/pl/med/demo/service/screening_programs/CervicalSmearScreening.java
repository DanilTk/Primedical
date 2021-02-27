package pl.med.demo.service.screening_programs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.Gender;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.ScreeningType;
import pl.med.demo.model.UserQuestionnaire;

@Service
@RequiredArgsConstructor
public class CervicalSmearScreening implements Screening {

    @Override
    public Prescription performScreening(UserQuestionnaire userQuestionnaire) {
        boolean isHealthy = true;
        int age = userQuestionnaire.getAge();

        if (age > 25 && age <= 59 && userQuestionnaire.getGender().equals(Gender.F)) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder()
                    .isHealthy(false)
                    .relevanceNote("Cervical screening picks up changes in the cells covering the cervix (the neck of your womb) that could develop into cancer in the future. It isn’t a test for cancer. It’s a test for abnormal pre-cancerous changes in these cells, which can then be treated to stop cancer developing.")
                    .screeningType(ScreeningType.CERVICAL_SMEAR_SCREENING)
                    .build();
        }
    }
}
