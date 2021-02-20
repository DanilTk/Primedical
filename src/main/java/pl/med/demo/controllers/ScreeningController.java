package pl.med.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserQuestionnaire;
import pl.med.demo.service.ScreeningService;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/screenings")
@RequiredArgsConstructor
public class ScreeningController {
    private final ScreeningService screeningService;

    @GetMapping(value = "/all")
    ResponseEntity<Set<Prescription>> conductFullScreening(UserQuestionnaire userQuestionnaire) {
        return ResponseEntity.status(HttpStatus.OK).body(screeningService.screenForPrescriptions(userQuestionnaire));
    }
}
