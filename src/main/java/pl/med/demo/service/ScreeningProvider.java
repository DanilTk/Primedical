package pl.med.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserQuestionnaire;
import pl.med.demo.service.screening_programs.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScreeningProvider {
    private final DiabetesScreening diabetesScreening;
    private final CholesterolScreening cholesterolScreening;
    private final HypertensionScreening hypertensionScreening;
    private final ColonoscopyScreening colonoscopyScreening;
    private final CervicalSmearScreening cervicalSmearScreening;
    private final FolicAcidSupplementationScreening folicAcidSupplementationScreening;
    private final HIVScreening hivScreening;

    public List<Prescription> conductAllScreenings(UserQuestionnaire userQuestionnaire) {
        Prescription diabetesPrescription = diabetesScreening.performScreening(userQuestionnaire);
        Prescription cholesterolPrescription = cholesterolScreening.performScreening(userQuestionnaire);
        Prescription hypertensionPrescription = hypertensionScreening.performScreening(userQuestionnaire);
        Prescription colonoscopyPrescription = colonoscopyScreening.performScreening(userQuestionnaire);
        Prescription cervicalSmearPrescription = cervicalSmearScreening.performScreening(userQuestionnaire);
        Prescription folicAcidSupplementationPrescription = folicAcidSupplementationScreening.performScreening(userQuestionnaire);
        Prescription hivTestPrescription = hivScreening.performScreening(userQuestionnaire);

        return List.of(diabetesPrescription,
                cholesterolPrescription,
                hypertensionPrescription,
                colonoscopyPrescription,
                hivTestPrescription,
                folicAcidSupplementationPrescription,
                cervicalSmearPrescription);
    }
}
