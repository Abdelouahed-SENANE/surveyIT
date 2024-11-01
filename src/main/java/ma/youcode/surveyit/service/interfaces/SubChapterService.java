package ma.youcode.surveyit.service.interfaces;


import ma.youcode.surveyit.dto.request.subchapter.SubChapterCreateDTO;
import ma.youcode.surveyit.dto.request.subchapter.SubChapterUpdateDTO;
import ma.youcode.surveyit.dto.response.subchapter.SubChapterResponseDTO;

import java.util.List;

public interface SubChapterService {
    List<SubChapterResponseDTO> getAllSubChapters();
    SubChapterResponseDTO getSubChapter(Long id);
    SubChapterResponseDTO createSubChapter(SubChapterCreateDTO dto , Long chapterId);
    SubChapterResponseDTO editSubChapter(SubChapterUpdateDTO dto , Long id);
    void deleteSubChapter(Long id);

}
