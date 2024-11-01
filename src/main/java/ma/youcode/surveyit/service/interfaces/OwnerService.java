package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.owner.OwnerCreateDTO;
import ma.youcode.surveyit.dto.response.owner.OwnerResponseDTO;
import ma.youcode.surveyit.dto.request.owner.OwnerUpdateDTO;
import ma.youcode.surveyit.entity.Owner;

import java.util.List;

public interface OwnerService {
    List<OwnerResponseDTO> getAllOwners();
    OwnerResponseDTO getOwner(Long id);
    OwnerResponseDTO createOwner(OwnerCreateDTO dto);
    OwnerResponseDTO editOwner(OwnerUpdateDTO dto , Long id);
    void deleteOwner(Long id);
    Owner getOwnerEntity(Long id);


}
