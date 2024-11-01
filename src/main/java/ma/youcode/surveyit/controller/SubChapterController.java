package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.youcode.surveyit.annotation.interfaces.Exists;
import ma.youcode.surveyit.dto.request.subchapter.SubChapterUpdateDTO;
import ma.youcode.surveyit.dto.response.subchapter.SubChapterResponseDTO;
import ma.youcode.surveyit.dto.response.transfer.SuccessResponseDTO;
import ma.youcode.surveyit.entity.Chapter;
import ma.youcode.surveyit.service.interfaces.SubChapterService;
import ma.youcode.surveyit.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subchapters")
@AllArgsConstructor
public class SubChapterController {

    private final SubChapterService service;

    @GetMapping
    public ResponseEntity<SuccessResponseDTO> subChapters() {

        List<SubChapterResponseDTO> subChapters = service.getAllSubChapters();
        return Response.success(200,
                "Sub chapters retrieve successfully",
                "subChapters",
                subChapters
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> SubChapter(
            @Valid
            @PathVariable
            @Exists(entity = Chapter.class, message = "Sub chapter not found.") Long id
    ) {

        SubChapterResponseDTO response = service.getSubChapter(id);

        return Response.success(200,
                "Sub chapter retrieve successfully",
                "subChapter",
                response
        );
    }

//    @PostMapping("/{subChapterId}/questions")
//    public ResponseEntity<SuccessResponseDTO> create(
//            @Valid
//            @PathVariable
//            @Exists(entity = Chapter.class, message = "Sub chapter not found.") Long subChapterId,
//            @Valid
//            @RequestBody SubChapterUpdateDTO dto
//    ) {
//
//        SubChapterResponseDTO response = service.editSubChapter(dto, subChapterId);
//        return Response.success(200,
//                "Sub chapter updated successfully",
//                "subChapter",
//                response
//        );
//    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> edit(
            @Valid
            @PathVariable
            @Exists(entity = Chapter.class, message = "Sub chapter not found.") Long id,
            @Valid
            @RequestBody SubChapterUpdateDTO dto
    ) {

        SubChapterResponseDTO response = service.editSubChapter(dto, id);
        return Response.success(200,
                "Sub chapter updated successfully",
                "subChapter",
                response
        );
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> delete(
            @PathVariable
            @Exists(entity = Chapter.class, message = "Sub chapter not found.") Long id
    ) {
        service.deleteSubChapter(id);
        return Response.success(200,
                "SubChapter deleted successfully",
                "surveyId",
                id
        );
    }
}
