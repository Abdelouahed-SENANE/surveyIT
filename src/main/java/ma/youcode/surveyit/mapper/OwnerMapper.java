package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.request.OwnerCreateDTO;
import ma.youcode.surveyit.dto.request.OwnerUpdateDTO;
import ma.youcode.surveyit.dto.response.OwnerEmbeddedDTO;
import ma.youcode.surveyit.dto.response.OwnerResponseDTO;
import ma.youcode.surveyit.entity.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    OwnerResponseDTO toResponseDTO(Owner owner);
    OwnerEmbeddedDTO toEmbeddedDTO(Owner owner);

    Owner toOwner(OwnerCreateDTO dto);
    Owner toOwner(OwnerUpdateDTO dto);


}
