package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.owner.CreateDTO;
import ma.youcode.surveyit.dto.owner.ResponseDTO;
import ma.youcode.surveyit.dto.owner.UpdateDTO;
import ma.youcode.surveyit.entity.Owner;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface OwnerService {
    List<ResponseDTO> getAllOwners();
    ResponseDTO getOwner(Long id);
    void createOwner(CreateDTO dto);
    void editOwner(UpdateDTO dto);
    void deleteOwner(Long id);



}
