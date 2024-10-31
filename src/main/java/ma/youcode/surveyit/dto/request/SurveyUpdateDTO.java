package ma.youcode.surveyit.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record SurveyUpdateDTO
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
