package ma.youcode.surveyit.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public record SuccessDTO(int code , String message , Map<String , Object> data , LocalDateTime timestamp) {
}
