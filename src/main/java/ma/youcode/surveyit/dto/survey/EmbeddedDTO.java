package ma.youcode.surveyit.dto.survey;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record EmbeddedDTO(@NotNull
                            Long id,
                          @NotEmpty
                            String title,
                          @NotEmpty
                            String description
) implements Serializable {
}
