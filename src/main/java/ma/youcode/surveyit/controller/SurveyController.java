package ma.youcode.surveyit.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.response.transfer.SuccessResponseDTO;
import ma.youcode.surveyit.dto.request.survey.SurveyCreateDTO;
import ma.youcode.surveyit.dto.request.survey.SurveyUpdateDTO;
import ma.youcode.surveyit.dto.response.survey.SurveyResponseDTO;
import ma.youcode.surveyit.entity.Survey;
import ma.youcode.surveyit.service.interfaces.SurveyService;
import ma.youcode.surveyit.util.Response;
import ma.youcode.surveyit.annotation.interfaces.Exists;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/surveys")
@AllArgsConstructor
public class SurveyController {

    private final SurveyService service;

    @GetMapping
    public ResponseEntity<SuccessResponseDTO> surveys() {

        List<SurveyResponseDTO> surveys = service.getAllSurveys();
        return Response.success(200,
                "Surveys retrieve successfully",
                "surveys",
                surveys
        );

    }

    @GetMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> survey(
            @Valid
            @PathVariable
            @Exists(entity = Survey.class, message = "Survey Not Found") Long id
    ) {

        SurveyResponseDTO response = service.getSurvey(id);

        return Response.success(200,
                " Survey retrieve successfully",
                "survey",
                response
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> edit(
            @Valid
            @PathVariable
            @Exists(entity = Survey.class, message = "Survey Not Found") Long id,
            @Valid
            @RequestBody SurveyUpdateDTO dto
    ) {

        SurveyResponseDTO response = service.editSurvey(dto, id);
        return Response.success(200,
                "Survey updated successfully",
                "survey",
                response
        );
    }

    @PostMapping
    public ResponseEntity<SuccessResponseDTO> create(
            @Valid @RequestBody SurveyCreateDTO dto
    ) {

        SurveyResponseDTO response = service.createSurvey(dto);
        return Response.success(201,
                "Survey Created successfully",
                "survey",
                response
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<SuccessResponseDTO> delete(
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
