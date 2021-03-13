package pl.med.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClarifyingMessage {
    private MessageField messageField;
    private String exceptionMessage;
}
