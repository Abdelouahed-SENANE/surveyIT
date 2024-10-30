package ma.youcode.surveyit.dto.owner;

import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;

public record UpdateDTO
        (
                Long id,
                @NotEmpty
                String name
        )

        implements Serializable {
}
