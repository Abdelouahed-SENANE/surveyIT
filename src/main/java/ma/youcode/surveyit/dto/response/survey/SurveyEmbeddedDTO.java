package ma.youcode.surveyit.dto.response.survey;

import ma.youcode.surveyit.dto.response.owner.OwnerEmbeddedDTO;

import java.io.Serializable;

public record SurveyEmbeddedDTO(
                            Long id,
                            String title,
                            String description,
                            OwnerEmbeddedDTO owner
) implements Serializable {
}
