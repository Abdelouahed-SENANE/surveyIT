package ma.youcode.surveyit.mapper;

import ma.youcode.surveyit.dto.request.subchapter.SubChapterCreateDTO;
import ma.youcode.surveyit.dto.request.subchapter.SubChapterUpdateDTO;
import ma.youcode.surveyit.dto.response.subchapter.SubChapterResponseDTO;
import ma.youcode.surveyit.entity.Chapter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubChapterMapper {

    SubChapterResponseDTO toResponseDTO(Chapter chapter);

    Chapter toChapter(SubChapterCreateDTO dto);
    Chapter toChapter(SubChapterUpdateDTO dto);


}
