package ma.youcode.surveyit.dto.response;

import java.io.Serializable;
import java.time.LocalDateTime;


public record EditionResponseDTO(
                          Long id,
                          LocalDateTime creationDate,
                          LocalDateTime startDate,
                          SurveyEmbeddedDTO survey
) implements Serializable {
}
