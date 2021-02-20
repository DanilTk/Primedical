package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Prescription {
    private boolean isHealthy;
    private String relevanceNote;
    private ScreeningType screeningType;
}
