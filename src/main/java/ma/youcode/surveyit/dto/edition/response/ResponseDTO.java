package ma.youcode.surveyit.dto.edition.response;

import ma.youcode.surveyit.dto.survey.response.EmbeddedDTO;

import java.io.Serializable;


public record ResponseDTO(
                          Long id,
                          String title,
                          String description,
                          EmbeddedDTO survey
) implements Serializable {
}
