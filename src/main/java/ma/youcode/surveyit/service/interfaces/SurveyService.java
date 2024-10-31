package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.survey.CreateDTO;
import ma.youcode.surveyit.dto.survey.ResponseDTO;
import ma.youcode.surveyit.dto.survey.UpdateDTO;

import java.util.List;

public interface SurveyService {
    List<ResponseDTO> getAllSurveys();
    ResponseDTO getSurvey(Long id);
    ResponseDTO createSurvey(CreateDTO dto);
    ResponseDTO editSurvey(UpdateDTO dto , Long id);
    void deleteSurvey(Long id);



}
