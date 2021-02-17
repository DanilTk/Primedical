package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
public class Prescription {
    private boolean isHealthy;
    private String relevanceNote;
    private String prescriptionNote;
    private Set<DoctorProfile> doctors;
}
