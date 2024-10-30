package ma.youcode.surveyit.service.implementations;

import ma.youcode.surveyit.dto.owner.CreateDTO;
import ma.youcode.surveyit.dto.owner.ResponseDTO;
import ma.youcode.surveyit.dto.owner.UpdateDTO;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.mapper.OwnerMapper;
import ma.youcode.surveyit.repository.OwnerRepository;
import ma.youcode.surveyit.service.interfaces.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImp implements OwnerService {

    @Autowired
    private OwnerRepository repository;
    @Autowired
    private OwnerMapper mapper;

    @Override
    public ResponseDTO createOwner(CreateDTO dto) {
        Owner owner = mapper.toOwner(dto);
        repository.save(owner);
        return mapper.toResponseDTO(owner);
    }

    @Override
    public ResponseDTO editOwner(UpdateDTO dto , Long id) {
        Owner owner = mapper.toOwner(dto);
        owner.setId(id);
        repository.save(owner);
        return mapper.toResponseDTO(owner);

    }

    @Override
    public void deleteOwner(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ResponseDTO> getAllOwners() {

        return repository.findAll().stream()
                .map(mapper::toResponseDTO).toList();

    }

    @Override
    public ResponseDTO getOwner(Long id) {
        Owner owner = repository.findById(id).orElse(null);
        return mapper.toResponseDTO(owner);
    }


}
