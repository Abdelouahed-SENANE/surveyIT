package ma.youcode.surveyit.dto.owner;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.util.annotations.interfaces.Exist;

import java.io.Serializable;

public record UpdateDTO
        (
                @Exist(message = "Owner Not Found")
                @NotNull
                Long id,
                @NotEmpty
                String name
        )

        implements Serializable {
}
