package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.youcode.surveyit.annotation.interfaces.Exists;
import ma.youcode.surveyit.dto.response.SuccessResponseDTO;
import ma.youcode.surveyit.dto.request.EditionCreateDTO;
import ma.youcode.surveyit.dto.request.EditionUpdateDTO;
import ma.youcode.surveyit.dto.response.EditionResponseDTO;
import ma.youcode.surveyit.entity.Edition;
import ma.youcode.surveyit.service.interfaces.EditionService;
import ma.youcode.surveyit.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editions")
@AllArgsConstructor
public class EditionController {

    private final EditionService service;

    @GetMapping
    public ResponseEntity<SuccessResponseDTO> editions() {

        List<EditionResponseDTO> editions = service.getAllEditions();
        return Response.success(200,
                "Editions retrieve successfully",
                "editions",
                editions
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> edition(
            @Valid
            @PathVariable
            @Exists(entity = Edition.class, message = "Edition Not Found") Long id
    ) {

        EditionResponseDTO response = service.getEdition(id);

        return Response.success(200,
                "Edition retrieve successfully",
                "edition",
                response
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> edit(
            @PathVariable
            @Valid @Exists(entity = Edition.class, message = "Edition Not Found") Long id,
            @RequestBody @Valid EditionUpdateDTO dto
    ) {

        EditionResponseDTO response = service.editEdition(dto, id);
        return Response.success(200,
                "Edition updated successfully",
                "edition",
                response
        );
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessResponseDTO> add(
            @Valid @RequestBody EditionCreateDTO dto
    ) {

        EditionResponseDTO response = service.createEdition(dto);
        return Response.success(201,
                "Edition Created successfully",
                "edition",
                response
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> delete(
            @PathVariable
            @Exists(entity = Edition.class, message = "Edition not found") Long id
    ) {
        service.deleteEdition(id);
        return Response.success(200,
                "Edition deleted successfully",
                "editionId",
                id
        );
    }
}
