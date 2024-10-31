package ma.youcode.surveyit.service.implementations;

import jakarta.persistence.EntityExistsException;
import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.request.SurveyCreateDTO;
import ma.youcode.surveyit.dto.response.SurveyResponseDTO;
import ma.youcode.surveyit.dto.request.SurveyUpdateDTO;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.entity.Survey;
import ma.youcode.surveyit.exception.EntityNotFoundException;
import ma.youcode.surveyit.mapper.SurveyMapper;
import ma.youcode.surveyit.repository.SurveyRepository;
import ma.youcode.surveyit.service.interfaces.OwnerService;
import ma.youcode.surveyit.service.interfaces.SurveyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class SurveyServiceImp implements SurveyService {

    private final SurveyRepository repository;
    private final SurveyMapper mapper;
    private final OwnerService ownerService;

    @Override
    @Transactional
    public SurveyResponseDTO createSurvey(SurveyCreateDTO dto) {

        Owner owner = ownerService.getOwnerEntity(dto.ownerId());

        Survey survey = mapper.toSurvey(dto);
        survey.setOwner(owner);

        return mapper.toResponseDTO(repository.save(survey));

    }

    @Override
    public SurveyResponseDTO editSurvey(SurveyUpdateDTO dto , Long id) {

        if (isTaken(dto.title() , id)) {
            throw new EntityExistsException("A survey with the title '" + dto.title() + "' already exists. Please choose a different title.");
        }

        Survey survey = mapper.toSurvey(dto);
        survey.setId(id);
        return mapper.toResponseDTO(repository.save(survey));

    }

    @Override
    public void deleteSurvey(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<SurveyResponseDTO> getAllSurveys() {

        return repository.findAll().stream()
                .map(mapper::toResponseDTO).toList();

    }

    @Override
    public SurveyResponseDTO getSurvey(Long id) {
        Survey survey = repository.findById(id).orElse(null);
        return mapper.toResponseDTO(survey);
    }

    private boolean isTaken(String title , Long id) {
        return repository.existsByTitleNotId(title , id);
    }

    @Override
    public Survey getSurveyEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Survey not found."));
    }
}
