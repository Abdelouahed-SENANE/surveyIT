package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.edition.request.CreateDTO;
import ma.youcode.surveyit.dto.edition.response.EmbeddedDTO;
import ma.youcode.surveyit.dto.edition.response.ResponseDTO;
import ma.youcode.surveyit.dto.edition.request.UpdateDTO;
import ma.youcode.surveyit.entity.Edition;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EditionMapper {

    ResponseDTO toResponseDTO(Edition edition);
    EmbeddedDTO toEmbeddedDTO(Edition edition);

    @Mapping(source = "surveyId" , target = "survey.id")
    Edition toEdition(CreateDTO dto);
    @Mapping(source = "surveyId" , target = "survey.id")
    Edition toEdition(UpdateDTO dto);


}
