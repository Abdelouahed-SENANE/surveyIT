package ma.youcode.surveyit.dto.owner;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public record CreateDTO(@NotEmpty String name) implements Serializable { }
