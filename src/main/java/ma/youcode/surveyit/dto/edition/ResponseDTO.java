package ma.youcode.surveyit.dto.edition;

import ma.youcode.surveyit.dto.survey.EmbeddedDTO;

import java.io.Serializable;


public record ResponseDTO(
                          Long id,
                          String title,
                          String description,
                          EmbeddedDTO survey
) implements Serializable {
}
