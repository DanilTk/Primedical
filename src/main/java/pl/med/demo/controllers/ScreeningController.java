package pl.med.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.med.demo.model.*;
import pl.med.demo.service.ScreeningService;
import pl.med.demo.service.VisitService;

import java.util.Arrays;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/screenings")
@RequiredArgsConstructor
public class ScreeningController {
    private final ScreeningService screeningService;
    private final VisitService visitService;

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
    ResponseEntity<Set<Visit>> findVisits(ScreeningType screeningType) {
        return ResponseEntity.status(HttpStatus.OK).body(visitService.findVisitsOfType(screeningType));
    }

    /**
     * Типы болезней (Рак, Диабет, итп.)
     */


    @GetMapping(value = "/conditions")
    ResponseEntity<Set<ConditionName>> findConditions() {
        return ResponseEntity.status(HttpStatus.OK).body(Set.copyOf(Arrays.asList((ConditionName.values()))));
    }

    /**
     * Если у пользователя были наследственные болезни - нужно указать степень родства
     */

    @GetMapping(value = "/ralashionships")
    ResponseEntity<Set<RelationshipLevel>> findRelationshipLevels() {
        return ResponseEntity.status(HttpStatus.OK).body(Set.copyOf(Arrays.asList(RelationshipLevel.values())));
    }

    /**
     * Подтипы болезней (н.п. Рак - Лёгкие, Диабет - 1 уровень, итп.)
     */
    @GetMapping(value = "/condition-types")
    ResponseEntity<Set<ConditionType>> findConditionTypes() {
        return ResponseEntity.status(HttpStatus.OK).body(Set.copyOf(Arrays.asList(ConditionType.values())));
    }
}
