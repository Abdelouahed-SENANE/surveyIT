package ma.youcode.surveyit.dto.response;

import java.io.Serializable;

public record OwnerEmbeddedDTO(
        Long id,
        String name
) implements Serializable {
}
