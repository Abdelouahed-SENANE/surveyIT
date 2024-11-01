package ma.youcode.surveyit.dto.response.subchapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.youcode.surveyit.dto.response.chapter.ChapterEmbeddedDTO;

import java.io.Serializable;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_NULL)
public record SubChapterResponseDTO(
        Long id,
        String title,
        ChapterEmbeddedDTO chapter,
        List<SubChapterEmbeddedDTO> subChapters
) implements Serializable { }