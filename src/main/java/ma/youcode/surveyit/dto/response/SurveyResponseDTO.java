package ma.youcode.surveyit.dto.response;

import java.io.Serializable;


public record SurveyResponseDTO(
                          Long id,
                          String title,
                          String description,
                          OwnerEmbeddedDTO owner
) implements Serializable {
}
