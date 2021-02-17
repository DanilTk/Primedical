package pl.med.demo.service.screening_programs;

public interface RiskGroupScreening {

    default boolean isInRiskGroup(double bmi, int riskFactorScore, int riskFactorThreshold) {
        return bmi >= 25 && riskFactorScore >= riskFactorThreshold;
    }
}
