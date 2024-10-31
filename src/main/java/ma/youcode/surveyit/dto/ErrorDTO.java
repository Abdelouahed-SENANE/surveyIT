package ma.youcode.surveyit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorDTO(
        int status,
        String message,
        LocalDateTime timestamp,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        Optional<Map<String, String>> errors) implements Serializable {

    public ErrorDTO(int status, String message, LocalDateTime time) {
        this(status, message, time, Optional.empty());
    }

    public ErrorDTO(int status, String message, LocalDateTime time , Map<String , String> errors) {
        this(status, message, time, Optional.of(errors));
    }

}
