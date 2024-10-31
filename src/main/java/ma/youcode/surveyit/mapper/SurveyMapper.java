package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.request.SurveyCreateDTO;
import ma.youcode.surveyit.dto.request.SurveyUpdateDTO;
import ma.youcode.surveyit.dto.response.SurveyEmbeddedDTO;
import ma.youcode.surveyit.dto.response.SurveyResponseDTO;
import ma.youcode.surveyit.entity.Survey;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SurveyMapper {

    SurveyResponseDTO toResponseDTO(Survey survey);
    SurveyEmbeddedDTO toEmbeddedDTO(Survey survey);

    @Mapping(source = "ownerId" , target = "owner.id")
    Survey toSurvey(SurveyCreateDTO dto);
    @Mapping(source = "ownerId" , target = "owner.id")
    Survey toSurvey(SurveyUpdateDTO dto);


}
