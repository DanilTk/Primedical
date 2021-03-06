package pl.med.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
@RequestMapping(value = "/api/v1/screenings")
@RequiredArgsConstructor
public class ScreeningController {
    private final ScreeningService screeningService;
    private final VisitService visitService;
    private final RelationshipLevelService relationshipService;
    private final ConditionService conditionService;

    /**
     * Валидирует форму заполненную пользователем и возвращает результат содержащий список ошибок (если имеются) и список направлений (н.п. проверить почки, итп.)
     */

    @PostMapping
    ResponseEntity<ScreeningResult> conductFullScreening(@RequestBody UserQuestionnaire questionnaire) {
        ScreeningResult screeningResult = screeningService.conductScreening(questionnaire);

        if (screeningResult.getExceptionMessages().isEmpty()) {
            return ResponseEntity.status(HttpStatus.OK).body(screeningResult);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(screeningResult);
        }
    }

    /**
     * Позволяет найти список необходимых врачей / анализов в зависимости от направления
     */

    @GetMapping(value = "/visits")
    ResponseEntity<Set<Visit>> findVisits(@RequestParam ScreeningType screeningType) {
        return ResponseEntity.status(HttpStatus.OK).body(visitService.findVisitsOfType(screeningType));
    }

    /**
     * Если у пользователя были наследственные болезни - нужно указать степень родства
     */

    @GetMapping(value = "/relationships")
    ResponseEntity<Set<RelationshipLevel>> findRelationshipLevels() {
        return ResponseEntity.status(HttpStatus.OK).body(relationshipService.findAll());
    }

    /**
     * Типы болезней (Рак, Диабет, итп.)
     */

    @GetMapping(value = "/conditions")
    ResponseEntity<Set<ConditionName>> findConditions() {
        return ResponseEntity.status(HttpStatus.OK).body(conditionService.findAllConditions());
    }

    /**
     * Подтипы болезней (н.п. Рак - Лёгкие, Диабет - 1 уровень, итп.)
     */

    @GetMapping(value = "/condition-types")
    ResponseEntity<Map<ConditionName, Set<ConditionType>>> findConditionTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(conditionService.findAllConditionTypes());
    }
}