package pl.med.demo.service.screening_programs;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.ScreeningType;
import pl.med.demo.model.UserQuestionnaire;

@Service
@RequiredArgsConstructor
public class HIVScreening implements Screening {

    @Override
    public Prescription performScreening(UserQuestionnaire userQuestionnaire) {
        boolean isHealthy = true;
        int age = userQuestionnaire.getAge();

        if (age > 15 && age <= 59) {
            isHealthy = false;
        }

        if (isHealthy) {
            return confirmIsHealthy();
        } else {
            return Prescription.builder()
                    .isHealthy(false)
                    .relevanceNote("Studies found convincing evidence that identification and early treatment of HIV infection is of substantial benefit in reducing the risk of AIDS-related events or death.\n" +
                            "\n" +
                            "Most (67%) new diagnoses of HIV infection are attributed to male-to-male sexual contact and the estimated prevalence of HIV infection among men who have sex with men is 12%. Injection drug use is another important risk factor for HIV infection; the estimated prevalence of HIV infection among persons who inject drugs is 1.9%. Among female individuals 13 years and older, 87% of all new diagnoses were attributed to heterosexual contact and 12% to injection drug use.")
                    .screeningType(ScreeningType.HIV_INFECTION_TEST)
                    .build();
        }
    }
}
