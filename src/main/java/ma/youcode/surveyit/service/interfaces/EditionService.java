package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.edition.request.CreateDTO;
import ma.youcode.surveyit.dto.edition.response.ResponseDTO;
import ma.youcode.surveyit.dto.edition.request.UpdateDTO;

import java.util.List;

public interface EditionService {
    List<ResponseDTO> getAllEditions();
    ResponseDTO getEdition(Long id);
    ResponseDTO createEdition(CreateDTO dto);
    ResponseDTO editEdition(UpdateDTO dto , Long id);
    void deleteEdition(Long id);



}
