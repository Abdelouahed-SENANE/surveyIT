package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.youcode.surveyit.annotation.interfaces.Exists;
import ma.youcode.surveyit.dto.request.chapter.ChapterCreateDTO;
import ma.youcode.surveyit.dto.request.chapter.ChapterUpdateDTO;
import ma.youcode.surveyit.dto.response.transfer.SuccessResponseDTO;
import ma.youcode.surveyit.dto.response.chapter.ChapterResponseDTO;
import ma.youcode.surveyit.entity.Chapter;
import ma.youcode.surveyit.service.interfaces.ChapterService;
import ma.youcode.surveyit.util.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chapters")
@AllArgsConstructor
public class ChapterController {

    private final ChapterService service;

    @GetMapping
    public ResponseEntity<SuccessResponseDTO> chapters() {

        List<ChapterResponseDTO> chapters = service.getAllChapters();
        return Response.success(200,
                "Chapters retrieve successfully",
                "chapters",
                chapters
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> chapter(
            @Valid
            @PathVariable
            @Exists(entity = Chapter.class, message = "Chapter Not Found") Long id
    ) {

        ChapterResponseDTO response = service.getChapter(id);

        return Response.success(200,
                " Chapter retrieve successfully",
                "chapter",
                response
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> edit(
            @Valid
            @PathVariable
            @Exists(entity = Chapter.class, message = "Chapter Not Found") Long id,
            @Valid
            @RequestBody ChapterUpdateDTO dto
    ) {

        ChapterResponseDTO response = service.editChapter(dto, id);
        return Response.success(200,
                "Chapter updated successfully",
                "chapter",
                response
        );
    }

    @PostMapping("/{chapterId}/subchapters")
    public ResponseEntity<SuccessResponseDTO> create(
            @Valid @RequestBody ChapterCreateDTO dto , @Valid @PathVariable @Exists(entity = Chapter.class , message = "Chapter not found.") Long chapterId
    ) {
        ChapterResponseDTO response = service.createSubChapter(dto , chapterId);
        return Response.success(201,
                "Sub chapter Created successfully",
                "subChapter",
                response
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> delete(
            @PathVariable
            @Exists(entity = Chapter.class, message = "Chapter not found") Long id
    ) {
        service.deleteChapter(id);
        return Response.success(200,
                "Chapter deleted successfully",
                "surveyId",
                id
        );
    }
}
