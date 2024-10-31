package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.EditionCreateDTO;
import ma.youcode.surveyit.dto.request.EditionUpdateDTO;
import ma.youcode.surveyit.dto.response.EditionResponseDTO;

import java.util.List;

public interface EditionService {
    List<EditionResponseDTO> getAllEditions();
    EditionResponseDTO getEdition(Long id);
    EditionResponseDTO createEdition(EditionCreateDTO dto);
    EditionResponseDTO editEdition(EditionUpdateDTO dto , Long id);
    void deleteEdition(Long id);



}
