package ma.youcode.surveyit.dto.response.question;

import ma.youcode.surveyit.dto.response.chapter.ChapterEmbeddedDTO;
import ma.youcode.surveyit.dto.response.survey.SurveyEmbeddedDTO;
import ma.youcode.surveyit.enums.QuestionType;

import java.io.Serializable;
import java.time.LocalDateTime;


public record QuestionResponseDTO(
        Long id,
        String text,
        QuestionType type,
        int answerCount,
        ChapterEmbeddedDTO subchapter
) implements Serializable { }
