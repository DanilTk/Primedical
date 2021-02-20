package pl.med.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        UserQuestionnaire questionnaire = UserQuestionnaire.builder()
                .gender(Gender.M)
                .height(183)
                .weight(85)
                .age(36)
                .smokingQuestionnaire(new SmokingQuestionnaire(false, 0, 0, 0))
                .activityHours(5)
                .conditions(Set.of(new Condition(ConditionName.CVD, null)))
                .familyCondition(Collections.emptySet())
                .build();


}
