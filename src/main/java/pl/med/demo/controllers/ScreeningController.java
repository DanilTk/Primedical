package pl.med.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.med.demo.model.ScreeningResult;
import pl.med.demo.model.ScreeningType;
import pl.med.demo.model.UserQuestionnaire;
import pl.med.demo.model.Visit;
import pl.med.demo.service.ScreeningService;
import pl.med.demo.service.VisitService;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/screenings")
@RequiredArgsConstructor
public class ScreeningController {
    private final ScreeningService screeningService;
    private final VisitService visitService;

    @GetMapping
    ResponseEntity<ScreeningResult> conductFullScreening(UserQuestionnaire questionnaire) {
        ScreeningResult screeningResult = screeningService.conductScreening(questionnaire);

        if (screeningResult.getExceptionMessages().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(screeningResult);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(screeningResult);
        }
    }

    @GetMapping(value = "/visits")
    ResponseEntity<Set<Visit>> findVisits(ScreeningType screeningType) {
        return ResponseEntity.status(HttpStatus.OK).body(visitService.findVisitsOfType(screeningType));
    }
}
