package ma.youcode.surveyit.dto.owner.request;

import jakarta.validation.constraints.NotEmpty;
import ma.youcode.surveyit.annotation.interfaces.Unique;
import ma.youcode.surveyit.entity.Owner;

import java.io.Serializable;

public record CreateDTO(
        @NotEmpty
        @Unique(entity = Owner.class, field = "name")
        String name
) implements Serializable {
}
