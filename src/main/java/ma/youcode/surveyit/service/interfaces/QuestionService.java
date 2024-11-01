package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.question.QuestionCreateDTO;
import ma.youcode.surveyit.dto.request.question.QuestionUpdateDTO;
import ma.youcode.surveyit.dto.response.question.QuestionResponseDTO;

import java.util.List;

public interface QuestionService {
    List<QuestionResponseDTO> getAllQuestions();
    QuestionResponseDTO getQuestion(Long id);
    QuestionResponseDTO createQuestion(QuestionCreateDTO dto , Long editionId);
    QuestionResponseDTO editQuestion(QuestionUpdateDTO dto , Long id);
    void deleteQuestion(Long id);



}
