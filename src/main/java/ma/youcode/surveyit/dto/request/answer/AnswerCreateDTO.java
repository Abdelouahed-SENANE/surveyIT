package ma.youcode.surveyit.dto.request.answer;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public record AnswerCreateDTO(
        @NotEmpty
        String title
) implements Serializable { }
