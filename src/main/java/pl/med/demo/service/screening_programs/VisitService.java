package pl.med.demo.service.screening_programs;

import org.springframework.stereotype.Service;
import pl.med.demo.model.Doctor;
import pl.med.demo.model.Specialization;
import pl.med.demo.model.Visit;
import pl.med.demo.model.VisitType;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class VisitService { //todo: replace with builder or factory

    protected Set<Visit> prepareDiabetesVisits() {
        Visit visit1 = Visit.builder()
                .locationName("I-Lab, Chmielna 104")
                .visitPrice(BigDecimal.valueOf(10))
                .visitType(VisitType.LAB_TEST)
                .build();

        Visit visit2 = Visit.builder()
                .locationName("MediLine, Prosta 5")
                .visitPrice(BigDecimal.valueOf(12))
                .visitType(VisitType.LAB_TEST)
                .build();

        Visit visit3 = Visit.builder()
                .locationName("Synevo, Marszalkowska 14")
                .visitPrice(BigDecimal.valueOf(9))
                .visitType(VisitType.LAB_TEST)
                .build();

        return Set.of(visit1, visit2, visit3);
    }

    protected Set<Visit> prepareCholesterolVisits() {
        Visit visit1 = Visit.builder()
                .locationName("Synevo, Bagno 5")
                .visitPrice(BigDecimal.valueOf(9))
                .visitType(VisitType.LAB_TEST)
                .build();

        Visit visit2 = Visit.builder()
                .locationName("UltraLife, Grzybowska 14")
                .visitPrice(BigDecimal.valueOf(11))
                .visitType(VisitType.LAB_TEST)
                .build();

        Visit visit3 = Visit.builder()
                .locationName("MedCover, Pereca 128")
                .visitPrice(BigDecimal.valueOf(14))
                .visitType(VisitType.LAB_TEST)
                .build();

        return Set.of(visit1, visit2, visit3);
    }

    protected Set<Visit> prepareHypertensionVisits() {
        Visit visit1 = Visit.builder()
                .locationName("SmartMed, Powstancow 29")
                .visitPrice(BigDecimal.valueOf(50))
                .visitType(VisitType.SCREENING)
                .doctor(new Doctor("Jan", "Kowalski", Specialization.GP))
                .build();

        Visit visit2 = Visit.builder()
                .locationName("VipMed, Karolkowa 17A")
                .visitPrice(BigDecimal.valueOf(40))
                .visitType(VisitType.SCREENING)
                .doctor(new Doctor("Mariusz", "Pudzianowski", Specialization.GP))
                .build();

        Visit visit3 = Visit.builder()
                .locationName("EnelMed, Bohaterow 44")
                .visitPrice(BigDecimal.valueOf(45))
                .visitType(VisitType.SCREENING)
                .doctor(new Doctor("Karol", "Wojtyla", Specialization.GP))
                .build();

        return Set.of(visit1, visit2, visit3);
    }
}
