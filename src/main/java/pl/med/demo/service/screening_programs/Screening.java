package pl.med.demo.service.screening_programs;

import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserProfile;

public interface Screening {

    Prescription performScreening(UserProfile userProfile);
}
