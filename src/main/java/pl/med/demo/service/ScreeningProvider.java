package pl.med.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserQuestionnaire;
import pl.med.demo.service.screening_programs.CholesterolScreening;
import pl.med.demo.service.screening_programs.DiabetesScreening;
import pl.med.demo.service.screening_programs.HypertensionScreening;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class ScreeningProvider {
    private final DiabetesScreening diabetesScreening;
    private final CholesterolScreening cholesterolScreening;
    private final HypertensionScreening hypertensionScreening;

    public Set<Prescription> conductAllScreenings(UserQuestionnaire userQuestionnaire) {
        Prescription diabetesPrescription = diabetesScreening.performScreening(userQuestionnaire);
        Prescription cholesterolPrescription = cholesterolScreening.performScreening(userQuestionnaire);
        Prescription hypertensionPrescription = hypertensionScreening.performScreening(userQuestionnaire);

        return Set.of(diabetesPrescription,
                cholesterolPrescription,
                hypertensionPrescription);
    }
}
