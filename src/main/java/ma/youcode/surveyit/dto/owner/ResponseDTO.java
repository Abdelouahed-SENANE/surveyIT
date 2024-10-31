package ma.youcode.surveyit.dto.owner;

import jakarta.validation.constraints.NotEmpty;
import ma.youcode.surveyit.dto.survey.EmbeddedDTO;

import java.io.Serializable;
import java.util.List;

public record ResponseDTO(Long id , String name , List<EmbeddedDTO> surveys) implements Serializable {}
