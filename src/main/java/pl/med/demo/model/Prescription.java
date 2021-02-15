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
    private String note;
    private Set<DoctorProfile> doctors;
}
