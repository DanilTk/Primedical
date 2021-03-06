package pl.med.demo.dao;

import org.springframework.stereotype.Repository;
import pl.med.demo.model.ConditionType;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class ConditionTypeRepository {

    public Set<ConditionType> findCancerTypes() {

        return Arrays.stream(ConditionType.values())
                .filter(type -> type != ConditionType.NA)
                .filter(type -> !type.getConditionType().startsWith("Type"))
                .collect(Collectors.toSet());
    }

    public Set<ConditionType> findDiabetesTypes() {

        return Arrays.stream(ConditionType.values())
                .filter(type -> type.getConditionType().startsWith("Type"))
                .collect(Collectors.toSet());
    }
}
