package pl.med.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.med.demo.model.*;
import pl.med.demo.service.ScreeningService;
import pl.med.demo.service.VisitService;

import java.util.Collections;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/screenings")
@RequiredArgsConstructor
public class ScreeningController {
    private final ScreeningService screeningService;
    private final VisitService visitService;

    @GetMapping
    ResponseEntity<Set<Prescription>> conductFullScreening() {
        UserQuestionnaire questionnaire = UserQuestionnaire.builder()
                .gender(Gender.M)
                .height(183)
                .weight(85)
                .age(36)
                .smokingQuestionnaire(new SmokingQuestionnaire(false, 0, 0, 0))
                .activityHours(5)
                .conditions(Set.of(new Condition(ConditionName.CVD, null)))
                .familyCondition(Collections.emptySet())
                .build();

        return ResponseEntity.status(HttpStatus.OK).body(screeningService.screenForPrescriptions(questionnaire));
    }

    @GetMapping(value = "/visits")
    ResponseEntity<Set<Visit>> findVisits(ScreeningType screeningType) {
        return ResponseEntity.status(HttpStatus.OK).body(visitService.findVisitsOfType(screeningType));
    }
}
