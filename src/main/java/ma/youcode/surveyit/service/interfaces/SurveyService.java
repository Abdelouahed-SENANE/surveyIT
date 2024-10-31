package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.survey.request.CreateDTO;
import ma.youcode.surveyit.dto.survey.response.ResponseDTO;
import ma.youcode.surveyit.dto.survey.request.UpdateDTO;
import ma.youcode.surveyit.entity.Survey;

import java.util.List;

public interface SurveyService {
    List<ResponseDTO> getAllSurveys();
    ResponseDTO getSurvey(Long id);
    ResponseDTO createSurvey(CreateDTO dto);
    ResponseDTO editSurvey(UpdateDTO dto , Long id);
    void deleteSurvey(Long id);
    Survey getSurveyEntity(Long id);



}
