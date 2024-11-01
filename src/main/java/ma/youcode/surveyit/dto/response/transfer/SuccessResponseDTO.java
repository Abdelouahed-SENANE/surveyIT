package ma.youcode.surveyit.dto.response.transfer;

import java.time.LocalDateTime;
import java.util.Map;

public record SuccessResponseDTO(int status , String message , Map<String , Object> data , LocalDateTime timestamp) {

}
