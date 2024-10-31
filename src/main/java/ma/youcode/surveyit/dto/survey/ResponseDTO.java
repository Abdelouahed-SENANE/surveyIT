package ma.youcode.surveyit.dto.survey;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.dto.owner.EmbeddedDTO;

import java.io.Serializable;


public record ResponseDTO(@NotNull
                          Long id,
                          @NotEmpty
                          String title,
                          @NotEmpty
                          String description,
                          @NotNull
                          EmbeddedDTO owner
) implements Serializable {
}
