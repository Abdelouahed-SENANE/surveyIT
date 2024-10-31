package ma.youcode.surveyit.dto.survey;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record EmbeddedDTO(
                            Long id,
                            String title,
                            String description
) implements Serializable {
}
