package pl.med.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.med.demo.model.*;
import pl.med.demo.service.ConditionService;
import pl.med.demo.service.RelationshipLevelService;
import pl.med.demo.service.ScreeningService;
import pl.med.demo.service.VisitService;

import java.util.Map;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/v1/screenings", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class ScreeningController {
    private final ScreeningService screeningService;
    private final VisitService visitService;
    private final RelationshipLevelService relationshipService;
    private final ConditionService conditionService;

    @PostMapping
    ResponseEntity<ScreeningResult> conductFullScreening(@RequestBody UserQuestionnaire questionnaire) {
        ScreeningResult screeningResult = screeningService.conductScreening(questionnaire);

        if (screeningResult.getExceptionMessages().isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(screeningResult);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(screeningResult);
        }
    }

    @GetMapping(value = "/visits")
    ResponseEntity<Set<Visit>> findVisits(@RequestParam ScreeningType screeningType) {
        return ResponseEntity.status(HttpStatus.OK).body(visitService.findVisitsOfType(screeningType));
    }

    @GetMapping(value = "/relationships")
    ResponseEntity<Set<RelationshipLevel>> findRelationshipLevels() {
        return ResponseEntity.status(HttpStatus.OK).body(relationshipService.findAll());
    }

    @GetMapping(value = "/conditions")
    ResponseEntity<Set<ConditionName>> findConditions() {
        return ResponseEntity.status(HttpStatus.OK).body(conditionService.findAllConditions());
    }

    @GetMapping(value = "/condition-types")
    ResponseEntity<Map<ConditionName, Set<ConditionType>>> findConditionTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(conditionService.findAllConditionTypes());
    }
}