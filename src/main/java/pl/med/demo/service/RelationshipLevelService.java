package pl.med.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.dao.RelationshipLevelRepository;
import pl.med.demo.model.RelationshipLevel;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RelationshipLevelService {
    private final RelationshipLevelRepository relationshipLevelRepository;

    public Set<RelationshipLevel> findAll() {
        return relationshipLevelRepository.findAll();
    }
}
