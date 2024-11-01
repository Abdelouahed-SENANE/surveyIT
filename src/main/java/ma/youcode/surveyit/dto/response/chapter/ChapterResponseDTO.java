package ma.youcode.surveyit.dto.response.chapter;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import ma.youcode.surveyit.dto.response.edition.EditionEmbeddedDTO;
import ma.youcode.surveyit.dto.response.question.QuestionEmbeddedDTO;

import java.io.Serializable;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChapterResponseDTO(
        Long id,
        String title,
        EditionEmbeddedDTO edition,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<ChapterEmbeddedDTO> subchapters

) implements Serializable {
}
