package pl.med.demo.dao;

import org.springframework.stereotype.Component;
import pl.med.demo.model.RelationshipLevel;

import java.util.Set;

@Component
public class RelationshipLevelRepository {

    public Set<RelationshipLevel> findAll() {
        return Set.of(RelationshipLevel.values());
    }
}
