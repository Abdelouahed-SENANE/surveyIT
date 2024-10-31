package ma.youcode.surveyit.dto.owner.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record UpdateDTO
        (
                @NotNull
                Long id,
                @NotEmpty
                String name
        )

        implements Serializable {
}
