package ma.youcode.surveyit.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;

public record ValidationDTO(int statusCode , Map<String , String> errors , LocalDateTime timestamp) implements Serializable {}
