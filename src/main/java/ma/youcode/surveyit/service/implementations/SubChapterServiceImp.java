package ma.youcode.surveyit.service.implementations;

import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.request.subchapter.SubChapterCreateDTO;
import ma.youcode.surveyit.dto.request.subchapter.SubChapterUpdateDTO;
import ma.youcode.surveyit.dto.response.subchapter.SubChapterResponseDTO;
import ma.youcode.surveyit.entity.Chapter;
import ma.youcode.surveyit.exception.EntityNotFoundException;
import ma.youcode.surveyit.mapper.SubChapterMapper;
import ma.youcode.surveyit.repository.ChapterRepository;
import ma.youcode.surveyit.service.interfaces.SubChapterService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubChapterServiceImp implements SubChapterService {

    private final ChapterRepository repository;
    private final SubChapterMapper mapper;


    @Override
    public SubChapterResponseDTO createSubChapter(SubChapterCreateDTO dto, Long chapterId) {

        Chapter parent = repository.findById(chapterId).orElseThrow(() -> new EntityNotFoundException("Chapter not found."));

        Chapter subChapter = mapper.toChapter(dto);
        subChapter.setEdition(parent.getEdition());
        subChapter.setChapterId(parent.getId());

        return mapper.toResponseDTO(repository.save(subChapter));
    }

    @Override
    public SubChapterResponseDTO editSubChapter(SubChapterUpdateDTO dto, Long id) {

        Chapter chapter = mapper.toChapter(dto);
        chapter.setId(id);
        return mapper.toResponseDTO(repository.save(chapter));

    }

    @Override
    public void deleteSubChapter(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<SubChapterResponseDTO> getAllSubChapters() {

        return repository.findAllSubChapters().stream()
                .map(mapper::toResponseDTO).toList();

    }

    @Override
    public SubChapterResponseDTO getSubChapter(Long id) {
        Chapter chapter = repository.findById(id).orElse(null);
        return mapper.toResponseDTO(chapter);
    }

}
