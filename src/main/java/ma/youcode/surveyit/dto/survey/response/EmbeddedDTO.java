package ma.youcode.surveyit.dto.survey.response;

import java.io.Serializable;

public record EmbeddedDTO(
                            Long id,
                            String title,
                            String description
) implements Serializable {
}
