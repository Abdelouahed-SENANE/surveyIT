package ma.youcode.surveyit.dto.survey;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.entity.Survey;
import ma.youcode.surveyit.util.annotations.interfaces.Exist;

import java.io.Serializable;

public record UpdateDTO
        (
                @Exist(message = "Survey Not Found" , entity = Survey.class)
                @NotNull
                Long id,
                @NotEmpty
                String title,
                @NotEmpty
                String desc
        )

        implements Serializable {
}
