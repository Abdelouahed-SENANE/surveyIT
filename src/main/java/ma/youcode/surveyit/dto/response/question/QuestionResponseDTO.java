package ma.youcode.surveyit.dto.response.question;

import ma.youcode.surveyit.dto.response.survey.SurveyEmbeddedDTO;

import java.io.Serializable;
import java.time.LocalDateTime;


public record QuestionResponseDTO(
                          Long id,
                          LocalDateTime creationDate,
                          LocalDateTime startDate,
                          SurveyEmbeddedDTO survey
) implements Serializable {
}
