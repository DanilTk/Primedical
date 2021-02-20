package pl.med.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserQuestionnaire;
import pl.med.demo.service.screening_programs.ScreeningProvider;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreeningService {
    private final ScreeningProvider screeningProvider;

    public Set<Prescription> screenForPrescriptions(UserQuestionnaire userQuestionnaire) {
        Set<Prescription> prescriptions = screeningProvider.conductAllScreenings(userQuestionnaire);
        return filterToRelevantPrescriptions(prescriptions);
    }

    private Set<Prescription> filterToRelevantPrescriptions(Set<Prescription> prescriptions) {
        return prescriptions.stream()
                .filter(prescription -> !prescription.isHealthy())
                .collect(Collectors.toSet());
    }
}
