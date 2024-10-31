package ma.youcode.surveyit.dto.response;

import java.io.Serializable;

public record SurveyEmbeddedDTO(
                            Long id,
                            String title,
                            String description,
                            OwnerEmbeddedDTO owner
) implements Serializable {
}
