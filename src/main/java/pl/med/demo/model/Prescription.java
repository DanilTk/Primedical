package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class Prescription {
    private String note;
    private Set<DoctorProfile> doctors;
}
