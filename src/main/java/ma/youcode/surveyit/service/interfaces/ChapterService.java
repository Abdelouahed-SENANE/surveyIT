package ma.youcode.surveyit.service.interfaces;

import ma.youcode.surveyit.dto.request.chapter.ChapterCreateDTO;
import ma.youcode.surveyit.dto.request.chapter.ChapterUpdateDTO;
import ma.youcode.surveyit.dto.response.chapter.ChapterResponseDTO;
import ma.youcode.surveyit.entity.Chapter;

import java.util.List;

public interface ChapterService {
    List<ChapterResponseDTO> getAllChapters();
    ChapterResponseDTO getChapter(Long id);
    ChapterResponseDTO createChapter(ChapterCreateDTO dto , Long editionId);
    ChapterResponseDTO editChapter(ChapterUpdateDTO dto , Long id);
    void deleteChapter(Long id);
    Chapter findChapterById(Long chapterId);


}
