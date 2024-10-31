package ma.youcode.surveyit.service.implementations;

import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.survey.CreateDTO;
import ma.youcode.surveyit.dto.survey.ResponseDTO;
import ma.youcode.surveyit.dto.survey.UpdateDTO;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.entity.Survey;
import ma.youcode.surveyit.exception.EntityNotFoundException;
import ma.youcode.surveyit.mapper.SurveyMapper;
import ma.youcode.surveyit.repository.SurveyRepository;
import ma.youcode.surveyit.service.interfaces.SurveyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class SurveyServiceImp implements SurveyService {

    private final SurveyRepository repository;
    private final EntityManager manager;
    private final SurveyMapper mapper;

    @Override
    @Transactional
    public ResponseDTO createSurvey(CreateDTO dto) {

        Survey survey = mapper.toSurvey(dto);
        repository.save(survey);
        manager.refresh(survey);
        return mapper.toResponseDTO(survey);
    }

    @Override
    public ResponseDTO editSurvey(UpdateDTO dto , Long id) {

        Survey survey = mapper.toSurvey(dto);
        survey.setId(id);
        return mapper.toResponseDTO(repository.save(survey));

    }

    @Override
    public void deleteSurvey(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ResponseDTO> getAllSurveys() {

        return repository.findAll().stream()
                .map(mapper::toResponseDTO).toList();

    }

    @Override
    public ResponseDTO getSurvey(Long id) {
        Survey survey = repository.findById(id).orElse(null);
        return mapper.toResponseDTO(survey);
    }


}
