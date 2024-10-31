package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.owner.CreateDTO;
import ma.youcode.surveyit.dto.owner.EmbeddedDTO;
import ma.youcode.surveyit.dto.owner.ResponseDTO;
import ma.youcode.surveyit.dto.owner.UpdateDTO;
import ma.youcode.surveyit.entity.Owner;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OwnerMapper {

    ResponseDTO toResponseDTO(Owner owner);
    EmbeddedDTO toEmbeddedDTO(Owner owner);

    Owner toOwner(CreateDTO dto);
    Owner toOwner(UpdateDTO dto);


}
