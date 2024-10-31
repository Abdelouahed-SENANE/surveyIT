package ma.youcode.surveyit.dto.response;

import java.io.Serializable;
import java.util.List;

public record OwnerResponseDTO(Long id , String name , List<SurveyEmbeddedDTO> surveys) implements Serializable {}
