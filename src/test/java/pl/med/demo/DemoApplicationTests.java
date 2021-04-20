package pl.med.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.med.demo.model.*;
import pl.med.demo.service.ScreeningService;

import java.util.Collections;
import java.util.Set;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    ScreeningService screeningService;

    @Test
    @DisplayName("Should return correct result with prescriptions")
    void conductScreening() {

        //given:
        UserQuestionnaire questionnaire = buildQuestionnaire();

        //when:
        ScreeningResult result = screeningService.conductScreening(questionnaire);

        //then:
        Assertions.assertEquals(0, result.getExceptionMessages().size());
        Assertions.assertEquals(4, result.getPrescriptions().size());
    }

    private UserQuestionnaire buildQuestionnaire() {
        return UserQuestionnaire.builder()
                .gender(Gender.M)
                .height(183)
                .weight(85)
                .age(36)
                .smokingQuestionnaire(new SmokingQuestionnaire(false, 0, 0, 0))
                .activityHours(5)
                .conditions(Set.of(new Condition(ConditionName.CVD, null)))
                .familyConditions(Collections.emptyList())
                .build();
    }
}
