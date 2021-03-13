package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class ScreeningResult {
    private Set<Prescription> prescriptions;
    private List<ClarifyingMessage> exceptionMessages;
}
