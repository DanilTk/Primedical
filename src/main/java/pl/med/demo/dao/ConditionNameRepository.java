package pl.med.demo.dao;

import org.springframework.stereotype.Repository;
import pl.med.demo.model.ConditionName;

import java.util.Set;

@Repository
public class ConditionNameRepository {

    public Set<ConditionName> findAll() {
        return Set.of(ConditionName.values());
    }
}
