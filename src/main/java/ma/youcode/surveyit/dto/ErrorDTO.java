package ma.youcode.surveyit.dto;

import java.time.LocalDateTime;

public record ErrorDTO(int statusCode , String message , LocalDateTime timestamp) {
}
