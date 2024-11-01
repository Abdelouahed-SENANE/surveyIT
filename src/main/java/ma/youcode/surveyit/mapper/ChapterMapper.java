package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.request.chapter.ChapterCreateDTO;
import ma.youcode.surveyit.dto.request.chapter.ChapterUpdateDTO;
import ma.youcode.surveyit.dto.response.chapter.ChapterResponseDTO;
import ma.youcode.surveyit.entity.Chapter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChapterMapper {

    ChapterResponseDTO toResponseDTO(Chapter chapter);

    Chapter toChapter(ChapterCreateDTO dto);
    Chapter toChapter(ChapterUpdateDTO dto);


}
