package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SmokingQuestionnaire {
    private boolean isSmoker;
    private int minCigarettesSmoked;
    private int maxCigarettesSmoked;
    private int yearsOfSmoking;
}
