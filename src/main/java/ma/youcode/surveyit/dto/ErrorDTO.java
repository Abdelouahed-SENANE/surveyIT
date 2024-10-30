package ma.youcode.surveyit.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public record ErrorDTO(int status , String message , LocalDateTime timestamp) implements Serializable {
}
