package ma.youcode.surveyit.dto.owner.response;

import java.io.Serializable;

public record EmbeddedDTO(
        Long id,
        String name
) implements Serializable {
}
