package pl.med.demo.model;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class ScreeningResult {
    private Set<Prescription> prescriptions;
    private List<ExceptionMessage> exceptionMessages;
}
