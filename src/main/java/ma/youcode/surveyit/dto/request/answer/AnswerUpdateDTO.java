package ma.youcode.surveyit.dto.request.answer;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.annotation.interfaces.Exists;
import ma.youcode.surveyit.entity.Edition;

import java.io.Serializable;

public record AnswerUpdateDTO
        (
                @NotEmpty
                String title,
                @NotNull
                @Exists(entity = Edition.class, message = "Edition not found.")
                Long editionId
        )

        implements Serializable {
}
