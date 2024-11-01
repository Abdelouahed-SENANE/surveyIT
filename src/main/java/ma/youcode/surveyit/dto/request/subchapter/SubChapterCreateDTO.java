package ma.youcode.surveyit.dto.request.subchapter;

import jakarta.validation.constraints.NotEmpty;

import java.io.Serializable;

public record SubChapterCreateDTO(
        @NotEmpty
        String title
) implements Serializable { }
