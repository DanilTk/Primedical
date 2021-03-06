package pl.med.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.med.demo.dao.ConditionNameRepository;
import pl.med.demo.dao.ConditionTypeRepository;
import pl.med.demo.model.ConditionName;
import pl.med.demo.model.ConditionType;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ConditionService {
    private final ConditionNameRepository conditionNameRepository;
    private final ConditionTypeRepository conditionTypeRepository;

    public Set<ConditionName> findAllConditions() {
        return conditionNameRepository.findAll();
    }

    public Map<ConditionName, Set<ConditionType>> findAllConditionTypes() {
        Map<ConditionName, Set<ConditionType>> map = new HashMap<>();
        Set<ConditionType> cancerTypes = conditionTypeRepository.findCancerTypes();
        Set<ConditionType> diabetesTypes = conditionTypeRepository.findDiabetesTypes();
        Set<ConditionType> noType = Set.of(ConditionType.NA);

        findAllConditions().forEach(conditionName -> {
            if (conditionName == ConditionName.CANCER) {
                map.put(conditionName, cancerTypes);
            } else if (conditionName == ConditionName.DIABETES) {
                map.put(conditionName, diabetesTypes);
            } else {
                map.put(conditionName, noType);
            }
        });

        return map;
    }
}
