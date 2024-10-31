package ma.youcode.surveyit.service.implementations;

import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.edition.request.CreateDTO;
import ma.youcode.surveyit.dto.edition.response.ResponseDTO;
import ma.youcode.surveyit.dto.edition.request.UpdateDTO;
import ma.youcode.surveyit.entity.Edition;
import ma.youcode.surveyit.mapper.EditionMapper;
import ma.youcode.surveyit.repository.EditionRepository;
import ma.youcode.surveyit.service.interfaces.EditionService;
import ma.youcode.surveyit.service.interfaces.SurveyService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class EditionServiceImp implements EditionService {

    private final EditionRepository repository;
    private final EditionMapper mapper;
    private final SurveyService surveyService;

    @Override
    @Transactional
    public ResponseDTO createEdition(CreateDTO dto) {

//        Survey owner = surveyService.getOwnerEntity(dto.surveyId());

        Edition edition = mapper.toEdition(dto);
//        edition.setOwner(owner);

        return mapper.toResponseDTO(repository.save(edition));

    }

    @Override
    public ResponseDTO editEdition(UpdateDTO dto , Long id) {

        Edition edition = mapper.toEdition(dto);
        edition.setId(id);
        return mapper.toResponseDTO(repository.save(edition));

    }

    @Override
    public void deleteEdition(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ResponseDTO> getAllEditions() {

        return repository.findAll().stream()
                .map(mapper::toResponseDTO).toList();

    }

    @Override
    public ResponseDTO getEdition(Long id) {
        Edition edition = repository.findById(id).orElse(null);
        return mapper.toResponseDTO(edition);
    }


}
