package ma.youcode.surveyit.dto.edition.response;

import java.io.Serializable;

public record EmbeddedDTO(
        Long id,
        String title,
        String description,
        ma.youcode.surveyit.dto.survey.response.EmbeddedDTO survey
) implements Serializable {
}
