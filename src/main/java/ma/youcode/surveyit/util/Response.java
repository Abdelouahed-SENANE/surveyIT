package ma.youcode.surveyit.util;

import ma.youcode.surveyit.dto.response.transfer.SuccessResponseDTO;
import ma.youcode.surveyit.dto.response.transfer.ErrorResponseDTO;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Response {

    public static ResponseEntity<SuccessResponseDTO> success(int status, String message, String key, Object value) {
        Map<String, Object> payload = new HashMap<>();
        payload.put(key, value);
        return ResponseEntity.status(status).body((new SuccessResponseDTO(
                status,
                message,
                payload,
                LocalDateTime.now()
        )));

    }

    public static ResponseEntity<ErrorResponseDTO> error(int status, String message, LocalDateTime timestamp) {
        return ResponseEntity.status(status).body((new ErrorResponseDTO(
                status,
                message,
                timestamp
        )));

    }

    public static ResponseEntity<ErrorResponseDTO> error(int status,
                                                         String message,
                                                         LocalDateTime timestamp,
                                                         Map<String, String> errors) {
        return ResponseEntity.status(status).body((new ErrorResponseDTO(
                status,
                message,
                timestamp,
                errors
        )));

    }


}
