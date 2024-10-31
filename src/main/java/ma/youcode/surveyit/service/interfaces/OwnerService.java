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
    ResponseDTO createOwner(CreateDTO dto);
    ResponseDTO editOwner(UpdateDTO dto , Long id);
    void deleteOwner(Long id);
    Owner getOwnerEntity(Long id);


}
