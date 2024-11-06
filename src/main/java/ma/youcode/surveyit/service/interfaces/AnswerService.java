package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.answer.AnswerCreateDTO;
import ma.youcode.surveyit.dto.request.answer.AnswerUpdateDTO;
import ma.youcode.surveyit.dto.response.answer.AnswerResponseDTO;
import ma.youcode.surveyit.entity.Answer;
import ma.youcode.surveyit.entity.Question;

import java.util.List;

public interface AnswerService {
    List<AnswerResponseDTO> getAllAnswers();
    AnswerResponseDTO getAnswer(Long id);
    AnswerResponseDTO createAnswer(AnswerCreateDTO dto);
    AnswerResponseDTO editAnswer(AnswerUpdateDTO dto , Long id);
    void deleteAnswer(Long id);
    Answer findAnswerById(Long id);
    void editSelectionCount(Answer answer);


}
