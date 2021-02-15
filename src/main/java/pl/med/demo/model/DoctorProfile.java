package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Class describing a specialist's profile which a user can reach out for help
 */

@Data
@AllArgsConstructor
public class DoctorProfile {
    private String name;
    private String surname;
    private String specialization;
    private BigDecimal payRate;
}
