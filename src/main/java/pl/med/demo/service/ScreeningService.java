package pl.med.demo.service;

import org.springframework.stereotype.Service;
import pl.med.demo.model.Prescription;
import pl.med.demo.model.UserProfile;

import java.util.Set;

/**
 * Service aggregates all available screenings within one
 */

@Service
public class ScreeningService {

    public Set<Prescription> screenForPrescriptions(UserProfile userProfile) {
        return null;
    }
}
