package ma.youcode.surveyit.dto.owner.response;

import ma.youcode.surveyit.dto.survey.response.EmbeddedDTO;

import java.io.Serializable;
import java.util.List;

public record ResponseDTO(Long id , String name , List<EmbeddedDTO> surveys) implements Serializable {}
