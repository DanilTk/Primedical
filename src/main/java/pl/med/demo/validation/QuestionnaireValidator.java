package pl.med.demo.validation;

import org.springframework.stereotype.Component;
import pl.med.demo.model.ClarifyingMessage;
import pl.med.demo.model.ExceptionMessage;
import pl.med.demo.model.MessageField;
import pl.med.demo.model.UserQuestionnaire;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionnaireValidator {

    public List<ClarifyingMessage> validate(UserQuestionnaire userQuestionnaire) {
        List<ClarifyingMessage> messages = new ArrayList<>();
        ClarifyingMessage message;

        if (isAgeValid(userQuestionnaire.getAge())) {
            message = new ClarifyingMessage(MessageField.AGE, ExceptionMessage.INVALID_AGE.getMessage());
            messages.add(message);
        }

        if (isWeightValid(userQuestionnaire.getWeight())) {
            message = new ClarifyingMessage(MessageField.WEIGHT, ExceptionMessage.INVALID_WEIGHT.getMessage());
            messages.add(message);
        }

        if (isHeightValid(userQuestionnaire.getHeight())) {
            message = new ClarifyingMessage(MessageField.HEIGHT, ExceptionMessage.INVALID_HEIGHT.getMessage());
            messages.add(message);
        }

        if (userQuestionnaire.getSmokingQuestionnaire().isSmoker()
                && isYearsSmokedValid(userQuestionnaire.getSmokingQuestionnaire().getYearsOfSmoking(), userQuestionnaire.getAge())) {
            message = new ClarifyingMessage(MessageField.SMOKING_PERIOD, ExceptionMessage.INVALID_YEARS_SMOKED.getMessage());
            messages.add(message);
        }

        userQuestionnaire.getFamilyConditions().forEach(condition -> {
            if (isDiagnosisAgeValid(condition.getAgeOfConditionDetection())) {
                messages.add(new ClarifyingMessage(MessageField.DIAGNOSIS_AGE, ExceptionMessage.INVALID_DIAGNOSIS_AGE.getMessage()));
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
