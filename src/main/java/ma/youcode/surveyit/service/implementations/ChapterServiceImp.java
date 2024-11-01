package ma.youcode.surveyit.service.implementations;

import lombok.AllArgsConstructor;
import ma.youcode.surveyit.dto.request.chapter.ChapterCreateDTO;
import ma.youcode.surveyit.dto.request.chapter.ChapterUpdateDTO;
import ma.youcode.surveyit.dto.response.chapter.ChapterResponseDTO;
import ma.youcode.surveyit.entity.Edition;
import ma.youcode.surveyit.entity.Chapter;
import ma.youcode.surveyit.exception.EntityNotFoundException;
import ma.youcode.surveyit.mapper.ChapterMapper;
import ma.youcode.surveyit.repository.ChapterRepository;
import ma.youcode.surveyit.service.interfaces.EditionService;
import ma.youcode.surveyit.service.interfaces.ChapterService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ChapterServiceImp implements ChapterService {

    private final ChapterRepository repository;
    private final ChapterMapper mapper;
    private final EditionService editionService;

    @Override
    @Transactional
    public ChapterResponseDTO createChapter(ChapterCreateDTO dto, Long editionId) {

        Edition edition = editionService.getEditionEntity(editionId);

        Chapter chapter = mapper.toChapter(dto);
        chapter.setEdition(edition);


        return mapper.toResponseDTO( repository.save(chapter));

    }

    @Override
    public ChapterResponseDTO createSubChapter(ChapterCreateDTO dto, Long chapterId) {

        Chapter parent = repository.findById(chapterId).orElseThrow(() -> new EntityNotFoundException("Chapter not found."));

        Chapter subChapter = mapper.toChapter(dto);
        subChapter.setEdition(parent.getEdition());
        subChapter.setChapterId(parent.getId());

        return mapper.toResponseDTO(repository.save(subChapter));
    }

    @Override
    public ChapterResponseDTO editChapter(ChapterUpdateDTO dto, Long id) {

        Chapter chapter = mapper.toChapter(dto);
        chapter.setId(id);
        return mapper.toResponseDTO(repository.save(chapter));

    }

    @Override
    public void deleteChapter(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<ChapterResponseDTO> getAllChapters() {

        return repository.findAllChapters().stream()
                .map(mapper::toResponseDTO).toList();

    }

    @Override
    public ChapterResponseDTO getChapter(Long id) {
        Chapter chapter = repository.findById(id).orElse(null);
        return mapper.toResponseDTO(chapter);
    }

}
