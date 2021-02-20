package pl.med.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.model.ScreeningType;
import pl.med.demo.model.Visit;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class VisitService {
    private final VisitFactory visitFactory;

    public Set<Visit> findVisitsOfType(ScreeningType screeningType) {
        return visitFactory.getVisitsOfType(screeningType);
    }
}
