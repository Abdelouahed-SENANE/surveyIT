package ma.youcode.surveyit.dto.survey.response;

import ma.youcode.surveyit.dto.owner.response.EmbeddedDTO;

import java.io.Serializable;


public record ResponseDTO(
                          Long id,
                          String title,
                          String description,
                          EmbeddedDTO owner
) implements Serializable {
}
