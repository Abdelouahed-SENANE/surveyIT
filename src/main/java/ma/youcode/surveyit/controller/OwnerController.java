package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import ma.youcode.surveyit.dto.owner.CreateDTO;
import ma.youcode.surveyit.dto.owner.ResponseDTO;
import ma.youcode.surveyit.dto.owner.UpdateDTO;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.service.interfaces.OwnerService;
import ma.youcode.surveyit.util.annotations.interfaces.Exists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService service;

    @GetMapping
    public ResponseEntity<List<ResponseDTO>> owners() {
        return ResponseEntity.ok(service.getAllOwners());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> owner(@Valid @PathVariable @Exists(entity = Owner.class, message = "Owner Not Found") Long id) {
        return ResponseEntity.ok(service.getOwner(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDTO> edit(@PathVariable @Exists(entity = Owner.class, message = "Owner Not Found") Long id, @Valid @RequestBody UpdateDTO dto) {
        return ResponseEntity.ok(service.editOwner(dto, id));
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDTO> add(@Valid @RequestBody CreateDTO dto) {
        return ResponseEntity.ok(service.createOwner(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        service.deleteOwner(id);
        return ResponseEntity.ok(id);
    }
}
