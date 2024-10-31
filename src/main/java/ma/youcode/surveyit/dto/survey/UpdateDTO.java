package ma.youcode.surveyit.dto.survey;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.entity.Survey;
import ma.youcode.surveyit.util.annotations.interfaces.Exists;

import java.io.Serializable;

public record UpdateDTO
        (
                Long id,
                @NotEmpty
                String title,
                @NotEmpty
                String description,
                @NotNull
                Long ownerId
        )

        implements Serializable {
}
