package ma.youcode.surveyit.dto.survey;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public record ResponseDTO(Long id , @NotEmpty String name) implements Serializable {}
