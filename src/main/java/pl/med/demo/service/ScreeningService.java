package pl.med.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserQuestionnaire;
import pl.med.demo.service.screening_programs.CholesterolScreening;
import pl.med.demo.service.screening_programs.DiabetesScreening;
import pl.med.demo.service.screening_programs.HypertensionScreening;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreeningService {
    private final DiabetesScreening diabetesScreening;
    private final CholesterolScreening cholesterolScreening;
    private final HypertensionScreening hypertensionScreening;

    public Set<Prescription> screenForPrescriptions(UserQuestionnaire userQuestionnaire) { //todo: add screening provider for better cohesion
        Prescription diabetesPrescription = diabetesScreening.performScreening(userQuestionnaire);
        Prescription cholesterolPrescription = cholesterolScreening.performScreening(userQuestionnaire);
        Prescription hypertensionPrescription = hypertensionScreening.performScreening(userQuestionnaire);

        return Set.of(diabetesPrescription, cholesterolPrescription, hypertensionPrescription)
                .stream()
                .filter(prescription -> !prescription.isHealthy())
                .collect(Collectors.toSet());
    }
}
