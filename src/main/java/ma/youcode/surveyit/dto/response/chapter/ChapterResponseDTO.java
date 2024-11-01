package ma.youcode.surveyit.dto.response.chapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.youcode.surveyit.dto.response.subchapter.SubChapterEmbeddedDTO;

import java.io.Serializable;
import java.util.List;

public record ChapterResponseDTO(
        Long id,
        String title,
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<SubChapterEmbeddedDTO> subChapters

) implements Serializable {
}
