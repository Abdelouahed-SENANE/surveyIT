package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.SurveyCreateDTO;
import ma.youcode.surveyit.dto.response.SurveyResponseDTO;
import ma.youcode.surveyit.dto.request.SurveyUpdateDTO;
import ma.youcode.surveyit.entity.Survey;

import java.util.List;

public interface SurveyService {
    List<SurveyResponseDTO> getAllSurveys();
    SurveyResponseDTO getSurvey(Long id);
    SurveyResponseDTO createSurvey(SurveyCreateDTO dto);
    SurveyResponseDTO editSurvey(SurveyUpdateDTO dto , Long id);
    void deleteSurvey(Long id);
    Survey getSurveyEntity(Long id);



}
