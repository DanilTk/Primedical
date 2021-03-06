package pl.med.demo.service;

import org.springframework.stereotype.Service;
import pl.med.demo.model.*;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Set;

@Service
public class VisitFactory {

    public Set<Visit> getVisitsOfType(ScreeningType screeningType) {
        Set<Visit> visits = Collections.emptySet();

        switch (screeningType) {
            case DIABETES_SCREENING:
                visits = buildDiabetesVisits();
                break;
            case CHOLESTEROL_SCREENING:
                visits = buildCholesterolVisits();
                break;
            case HYPERTENSION_SCREENING:
                visits = buildHypertensionVisits();
                break;
            case COLONOSCOPY:
                visits = buildColonoscopyVisits();
                break;
            case FECAL_OCCULT_BLOOD_TEST:
                visits = buildFecalOccultBloodTestVisits();
                break;
            case CERVICAL_SMEAR_SCREENING:
                visits = buildCervicalSmearVisits();
                break;
        }

        return visits;
    }

    private Set<Visit> buildDiabetesVisits() {
        Visit visit1 = Visit.builder()
                .locationName("I-Lab, Chmielna 104")
                .visitPrice(BigDecimal.valueOf(10))
                .visitType(VisitType.LAB_TEST)
                .visitName(ScreeningType.DIABETES_SCREENING.getScreeningName())
                .build();

        Visit visit2 = Visit.builder()
                .locationName("MediLine, Prosta 5")
                .visitPrice(BigDecimal.valueOf(12))
                .visitType(VisitType.LAB_TEST)
                .visitName(ScreeningType.DIABETES_SCREENING.getScreeningName())
                .build();

        Visit visit3 = Visit.builder()
                .locationName("Synevo, Marszalkowska 14")
                .visitPrice(BigDecimal.valueOf(9))
                .visitType(VisitType.LAB_TEST)
                .visitName(ScreeningType.DIABETES_SCREENING.getScreeningName())
                .build();

        return Set.of(visit1, visit2, visit3);
    }

    private Set<Visit> buildCholesterolVisits() {
        Visit visit1 = Visit.builder()
                .locationName("Synevo, Bagno 5")
                .visitPrice(BigDecimal.valueOf(9))
                .visitType(VisitType.LAB_TEST)
                .visitName(ScreeningType.CHOLESTEROL_SCREENING.getScreeningName())
                .build();

        Visit visit2 = Visit.builder()
                .locationName("UltraLife, Grzybowska 14")
                .visitPrice(BigDecimal.valueOf(11))
                .visitType(VisitType.LAB_TEST)
                .visitName(ScreeningType.CHOLESTEROL_SCREENING.getScreeningName())
                .build();

        Visit visit3 = Visit.builder()
                .locationName("MedCover, Pereca 128")
                .visitPrice(BigDecimal.valueOf(14))
                .visitType(VisitType.LAB_TEST)
                .visitName(ScreeningType.CHOLESTEROL_SCREENING.getScreeningName())
                .build();

        return Set.of(visit1, visit2, visit3);
    }

    private Set<Visit> buildHypertensionVisits() {
        Visit visit1 = Visit.builder()
                .locationName("SmartMed, Powstancow 29")
                .visitPrice(BigDecimal.valueOf(50))
                .visitType(VisitType.SCREENING)
                .visitName(ScreeningType.HYPERTENSION_SCREENING.getScreeningName())
                .doctor(new Doctor("Jan", "Kowalski", Specialization.GP))
                .build();

        Visit visit2 = Visit.builder()
                .locationName("VipMed, Karolkowa 17A")
                .visitPrice(BigDecimal.valueOf(40))
                .visitType(VisitType.SCREENING)
                .visitName(ScreeningType.HYPERTENSION_SCREENING.getScreeningName())
                .doctor(new Doctor("Mariusz", "Pudzianowski", Specialization.GP))
                .build();

        Visit visit3 = Visit.builder()
                .locationName("EnelMed, Bohaterow 44")
                .visitPrice(BigDecimal.valueOf(45))
                .visitType(VisitType.SCREENING)
                .visitName(ScreeningType.HYPERTENSION_SCREENING.getScreeningName())
                .doctor(new Doctor("Karol", "Wojtyla", Specialization.GP))
                .build();

        return Set.of(visit1, visit2, visit3);
    }

    private Set<Visit> buildColonoscopyVisits() {
        Visit visit = Visit.builder()
                .locationName("Endoscopy Clinic, Ksawierow 15B")
                .visitPrice(BigDecimal.valueOf(250))
                .visitType(VisitType.SCREENING)
                .visitName(ScreeningType.COLONOSCOPY.getScreeningName())
                .doctor(new Doctor("Andrzej", "Jakimczuk", Specialization.GP))
                .build();

        return Set.of(visit);
    }

    private Set<Visit> buildFecalOccultBloodTestVisits() {
        Visit visit1 = Visit.builder()
                .locationName("Ilab, Powstancow 29")
                .visitPrice(BigDecimal.valueOf(13))
                .visitName(ScreeningType.FECAL_OCCULT_BLOOD_TEST.getScreeningName())
                .visitType(VisitType.LAB_TEST)
                .build();

        Visit visit2 = Visit.builder()
                .locationName("G-Clinic, Karolkowa 17A")
                .visitPrice(BigDecimal.valueOf(12))
                .visitName(ScreeningType.FECAL_OCCULT_BLOOD_TEST.getScreeningName())
                .visitType(VisitType.LAB_TEST)
                .build();

        Visit visit3 = Visit.builder()
                .locationName("Medline, Bohaterow 44")
                .visitPrice(BigDecimal.valueOf(10))
                .visitName(ScreeningType.FECAL_OCCULT_BLOOD_TEST.getScreeningName())
                .visitType(VisitType.LAB_TEST)
                .build();

        return Set.of(visit1, visit2, visit3);
    }

    private Set<Visit> buildCervicalSmearVisits() {
        Visit visit1 = Visit.builder()
                .locationName("SmartMed, Powstancow 29")
                .visitPrice(BigDecimal.valueOf(50))
                .visitType(VisitType.SCREENING)
                .visitName(ScreeningType.CERVICAL_SMEAR_SCREENING.getScreeningName())
                .doctor(new Doctor("Jan", "Kowalski", Specialization.GYNECOLOGIST))
                .build();

        Visit visit2 = Visit.builder()
                .locationName("VipMed, Karolkowa 17A")
                .visitPrice(BigDecimal.valueOf(40))
                .visitType(VisitType.SCREENING)
                .visitName(ScreeningType.CERVICAL_SMEAR_SCREENING.getScreeningName())
                .doctor(new Doctor("Mariusz", "Pudzianowski", Specialization.GYNECOLOGIST))
                .build();

        Visit visit3 = Visit.builder()
                .locationName("EnelMed, Bohaterow 44")
                .visitPrice(BigDecimal.valueOf(45))
                .visitType(VisitType.SCREENING)
                .visitName(ScreeningType.CERVICAL_SMEAR_SCREENING.getScreeningName())
                .doctor(new Doctor("Karol", "Wojtyla", Specialization.GYNECOLOGIST))
                .build();

        return Set.of(visit1, visit2, visit3);
    }
}
