package ma.youcode.surveyit.dto.edition;

import java.io.Serializable;

public record EmbeddedDTO(
        Long id,
        String title,
        String description,
        ma.youcode.surveyit.dto.survey.EmbeddedDTO survey
) implements Serializable {
}
