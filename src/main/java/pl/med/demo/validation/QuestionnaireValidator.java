package pl.med.demo.validation;

import org.springframework.stereotype.Component;
import pl.med.demo.model.ExceptionMessage;
import pl.med.demo.model.UserQuestionnaire;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionnaireValidator {

    public List<ExceptionMessage> validate(UserQuestionnaire userQuestionnaire) {
        List<ExceptionMessage> messages = new ArrayList<>();

        if (isAgeValid(userQuestionnaire.getAge())) {
            messages.add(ExceptionMessage.INVALID_AGE);
        }

        if (isWeightValid(userQuestionnaire.getWeight())) {
            messages.add(ExceptionMessage.INVALID_WEIGHT);
        }

        if (isHeightValid(userQuestionnaire.getHeight())) {
            messages.add(ExceptionMessage.INVALID_HEIGHT);
        }

        if (userQuestionnaire.getSmokingQuestionnaire().isSmoker()
                && isYearsSmokedValid(userQuestionnaire.getSmokingQuestionnaire().getYearsOfSmoking(), userQuestionnaire.getAge())) {
            messages.add(ExceptionMessage.INVALID_YEARS_SMOKED);
        }

        userQuestionnaire.getFamilyConditions().forEach(condition -> {
            if (isDiagnosisAgeValid(condition.getAgeOfConditionDetection())) {
                messages.add(ExceptionMessage.INVALID_DIAGNOSIS_AGE);
            }
        });

        return messages;
    }

    private boolean isAgeValid(int age) {
        return age < 18 || age > 99;
    }

    private boolean isWeightValid(int weight) {
        return weight < 30 || weight > 300;
    }

    private boolean isHeightValid(int height) {
        return height < 120 || height > 250;
    }

    private boolean isYearsSmokedValid(int yearsSmoked, int userAge) {
        return yearsSmoked > userAge;
    }

    private boolean isDiagnosisAgeValid(int age) {
        return age < 1 || age > 100;
    }
}
