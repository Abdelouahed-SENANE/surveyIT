package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.SuccessDTO;
import ma.youcode.surveyit.dto.owner.CreateDTO;
import ma.youcode.surveyit.dto.owner.ResponseDTO;
import ma.youcode.surveyit.dto.owner.UpdateDTO;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.service.interfaces.OwnerService;
import ma.youcode.surveyit.util.Response;
import ma.youcode.surveyit.annotations.interfaces.Exists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
@AllArgsConstructor
public class OwnerController {

    private final OwnerService service;

    @GetMapping
    public ResponseEntity<SuccessDTO> owners() {

        List<ResponseDTO> owners = service.getAllOwners();
        return Response.success(200,
                "Owners retrieve successfully",
                "owners",
                owners
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessDTO> owner(
            @Valid
            @PathVariable
            @Exists(entity = Owner.class, message = "Owner Not Found") Long id
    ) {

        ResponseDTO response = service.getOwner(id);
        System.out.println(response.surveys().toString());
        return Response.success(200,
                " Owner retrieve successfully",
                "owner",
                response
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessDTO> edit(
            @PathVariable
            @Valid @Exists(entity = Owner.class, message = "Owner Not Found") Long id,
            @RequestBody @Valid UpdateDTO dto
    ) {

        ResponseDTO response = service.editOwner(dto, id);
        return Response.success(200,
                "Owner updated successfully",
                "owner",
                response
        );
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessDTO> add(
            @Valid @RequestBody CreateDTO dto
    ) {

        ResponseDTO response = service.createOwner(dto);
        return Response.success(201,
                "Owner Created successfully",
                "owner",
                response
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessDTO> delete(
            @PathVariable
            @Exists(entity = Owner.class, message = "Owner not found") Long id
    ) {
        service.deleteOwner(id);
        return Response.success(200,
                "Owner deleted successfully",
                "ownerId",
                id
        );
    }
}
