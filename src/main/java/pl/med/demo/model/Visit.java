package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Visit {
    private Doctor doctor;
    private BigDecimal visitPrice;
    private VisitType visitType;
    private ScreeningType visitName;
    private String locationName;
}
