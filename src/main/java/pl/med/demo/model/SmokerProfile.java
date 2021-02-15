package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmokerProfile {
    private boolean isSmoker;
    private int minCigarettesSmoked;
    private int maxCigarettesSmoked;
    private int smokingPeriod;
}
