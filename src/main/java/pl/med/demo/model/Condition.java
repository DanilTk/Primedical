package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Condition {
    private ConditionName name;
    private ConditionType type;
}
