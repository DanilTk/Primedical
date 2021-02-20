package pl.med.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.ExceptionMessage;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.ScreeningResult;
import pl.med.demo.model.UserQuestionnaire;
import pl.med.demo.service.screening_programs.ScreeningProvider;
import pl.med.demo.validation.QuestionnaireValidator;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreeningService {
    private final ScreeningProvider screeningProvider;
    private final QuestionnaireValidator questionnaireValidator;

    public ScreeningResult conductScreening(UserQuestionnaire userQuestionnaire) {
        Set<Prescription> prescriptions = Collections.emptySet();
        List<ExceptionMessage> exceptionMessages = questionnaireValidator.validate(userQuestionnaire);

        if (exceptionMessages.isEmpty()) {
            prescriptions = screeningProvider.conductAllScreenings(userQuestionnaire);
            prescriptions = filterToRelevantPrescriptions(prescriptions);
        }

        return new ScreeningResult(prescriptions, exceptionMessages);
    }

    private Set<Prescription> filterToRelevantPrescriptions(Set<Prescription> prescriptions) {
        return prescriptions.stream()
                .filter(prescription -> !prescription.isHealthy())
                .collect(Collectors.toSet());
    }
}
