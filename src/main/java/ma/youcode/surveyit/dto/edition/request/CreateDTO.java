package ma.youcode.surveyit.dto.edition.request;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import ma.youcode.surveyit.entity.Survey;
import ma.youcode.surveyit.annotation.interfaces.Exists;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Year;

public record CreateDTO(
        @NotEmpty LocalDateTime creationDate ,
        @NotEmpty LocalDateTime startDate,
        @NotEmpty @Min(value = 0 , message = "Year must be positive") int year,
        @NotNull @Exists(entity = Survey.class , message = "Survey not found.") Long surveyId
) implements Serializable {

    @AssertTrue(message = "Year must be valid")
    public boolean isValidYear(){
        return year >= Year.now().getValue();
    }

}
