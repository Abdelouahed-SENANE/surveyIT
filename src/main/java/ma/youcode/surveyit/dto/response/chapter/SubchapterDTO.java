package ma.youcode.surveyit.dto.response.chapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ma.youcode.surveyit.dto.response.question.QuestionEmbeddedDTO;

import java.util.List;

public record SubchapterDTO(
        Long id,
        String title,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<QuestionEmbeddedDTO> questions
) {
}
