package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.survey.CreateDTO;
import ma.youcode.surveyit.dto.survey.EmbeddedDTO;
import ma.youcode.surveyit.dto.survey.ResponseDTO;
import ma.youcode.surveyit.dto.survey.UpdateDTO;
import ma.youcode.surveyit.entity.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

    ResponseDTO toResponseDTO(Survey survey);
    EmbeddedDTO toEmbeddedDTO(Survey survey);

    @Mapping(source = "ownerId" , target = "owner.id")
    Survey toSurvey(CreateDTO dto);
    @Mapping(source = "ownerId" , target = "owner.id")
    Survey toSurvey(UpdateDTO dto);


}
