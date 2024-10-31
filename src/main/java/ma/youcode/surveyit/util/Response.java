package ma.youcode.surveyit.util;

import ma.youcode.surveyit.dto.ErrorDTO;
import ma.youcode.surveyit.dto.SuccessDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Response {

    public static ResponseEntity<SuccessDTO> success(int status, String message, String key, Object value) {
        Map<String, Object> payload = new HashMap<>();
        payload.put(key, value);
        return ResponseEntity.status(status).body((new SuccessDTO(
                status,
                message,
                payload,
                LocalDateTime.now()
        )));

    }

    public static ResponseEntity<ErrorDTO> error(int status, String message, LocalDateTime timestamp) {
        return ResponseEntity.status(status).body((new ErrorDTO(
                status,
                message,
                timestamp
        )));

    }

    public static ResponseEntity<ErrorDTO> error(int status,
                                                 String message,
                                                 LocalDateTime timestamp,
                                                 Map<String, String> errors) {
        return ResponseEntity.status(status).body((new ErrorDTO(
                status,
                message,
                timestamp,
                errors
        )));

    }


}
