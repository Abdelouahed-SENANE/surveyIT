package ma.youcode.surveyit.dto.request.question;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public record QuestionCreateDTO(
        @NotEmpty
        String title
) implements Serializable { }
