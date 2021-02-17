package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Class describing a specialist's profile which a user can reach out for help
 */

@Data
@AllArgsConstructor
public class Doctor {
    private String name;
    private String surname;
    private Specialization specialization;
}
