package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.owner.request.CreateDTO;
import ma.youcode.surveyit.dto.owner.response.ResponseDTO;
import ma.youcode.surveyit.dto.owner.request.UpdateDTO;
import ma.youcode.surveyit.entity.Owner;

import java.util.List;

public interface OwnerService {
    List<ResponseDTO> getAllOwners();
    ResponseDTO getOwner(Long id);
    ResponseDTO createOwner(CreateDTO dto);
    ResponseDTO editOwner(UpdateDTO dto , Long id);
    void deleteOwner(Long id);
    Owner getOwnerEntity(Long id);


}
