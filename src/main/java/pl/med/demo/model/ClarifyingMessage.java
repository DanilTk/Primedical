package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClarifyingMessage {
    private MessageField messageField;
    private String exceptionMessage;
    private int index;

    public ClarifyingMessage(MessageField messageField, String exceptionMessage) {
        this.messageField = messageField;
        this.exceptionMessage = exceptionMessage;
    }
}
