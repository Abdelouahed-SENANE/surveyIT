package ma.youcode.surveyit.dto.survey;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.annotations.interfaces.Exists;

import java.io.Serializable;

public record CreateDTO(
        @NotEmpty String title ,
        @NotEmpty String description,
        @NotNull @Exists(entity = Owner.class , message = "Owner not found.") Long ownerId
) implements Serializable { }
