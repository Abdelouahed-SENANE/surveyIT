package ma.youcode.surveyit.dto.response.edition;

import ma.youcode.surveyit.dto.response.survey.SurveyEmbeddedDTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public record EditionEmbeddedDTO(
        Long id,
        LocalDateTime creationDate,
        LocalDateTime startDate,
        SurveyEmbeddedDTO survey
) implements Serializable {
}
