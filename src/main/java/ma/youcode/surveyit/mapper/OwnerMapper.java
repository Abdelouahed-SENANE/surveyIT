package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.owner.request.CreateDTO;
import ma.youcode.surveyit.dto.owner.response.EmbeddedDTO;
import ma.youcode.surveyit.dto.owner.response.ResponseDTO;
import ma.youcode.surveyit.dto.owner.request.UpdateDTO;
import ma.youcode.surveyit.entity.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    ResponseDTO toResponseDTO(Owner owner);
    EmbeddedDTO toEmbeddedDTO(Owner owner);

    Owner toOwner(CreateDTO dto);
    Owner toOwner(UpdateDTO dto);


}
