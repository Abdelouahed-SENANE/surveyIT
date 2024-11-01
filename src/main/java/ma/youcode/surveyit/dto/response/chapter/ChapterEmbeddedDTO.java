package ma.youcode.surveyit.dto.response.chapter;

import com.fasterxml.jackson.annotation.JsonInclude;
import ma.youcode.surveyit.dto.response.edition.EditionEmbeddedDTO;

import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChapterEmbeddedDTO(
                            Long id,
                            String title,
                            EditionEmbeddedDTO edition
) implements Serializable {
}
