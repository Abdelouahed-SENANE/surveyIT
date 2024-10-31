package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.SuccessDTO;
import ma.youcode.surveyit.dto.survey.CreateDTO;
import ma.youcode.surveyit.dto.survey.ResponseDTO;
import ma.youcode.surveyit.dto.survey.UpdateDTO;
import ma.youcode.surveyit.entity.Survey;
import ma.youcode.surveyit.service.interfaces.SurveyService;
import ma.youcode.surveyit.util.Response;
import ma.youcode.surveyit.annotations.interfaces.Exists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@AllArgsConstructor
public class SurveyController {

    private final SurveyService service;

    @GetMapping
    public ResponseEntity<SuccessDTO> surveys() {

        List<ResponseDTO> surveys = service.getAllSurveys();
        return Response.success(200,
                "Surveys retrieve successfully",
                "surveys",
                surveys
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessDTO> survey(
            @Valid
            @PathVariable
            @Exists(entity = Survey.class, message = "Survey Not Found") Long id
    ) {

        ResponseDTO response = service.getSurvey(id);

        return Response.success(200,
                " Survey retrieve successfully",
                "survey",
                response
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessDTO> edit(
            @PathVariable
            @Valid @Exists(entity = Survey.class, message = "Survey Not Found") Long id,
            @RequestBody @Valid UpdateDTO dto
    ) {

        ResponseDTO response = service.editSurvey(dto, id);
        return Response.success(200,
                "Survey updated successfully",
                "survey",
                response
        );
    }

    @PostMapping("/new")
    public ResponseEntity<SuccessDTO> add(
            @Valid @RequestBody CreateDTO dto
    ) {

        ResponseDTO response = service.createSurvey(dto);
        return Response.success(201,
                "Survey Created successfully",
                "survey",
                response
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessDTO> delete(
            @PathVariable
            @Exists(entity = Survey.class, message = "Survey not found") Long id
    ) {
        service.deleteSurvey(id);
        return Response.success(200,
                "Survey deleted successfully",
                "surveyId",
                id
        );
    }
}
