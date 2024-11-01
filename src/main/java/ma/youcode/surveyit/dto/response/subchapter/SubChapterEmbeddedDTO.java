package ma.youcode.surveyit.dto.response.subchapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.youcode.surveyit.dto.response.chapter.ChapterEmbeddedDTO;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubChapterEmbeddedDTO(
                            Long id,
                            String title,
                            ChapterEmbeddedDTO chapter
) implements Serializable {
}
