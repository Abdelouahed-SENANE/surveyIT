package ma.youcode.surveyit.repository;

import ma.youcode.surveyit.entity.Edition;
import ma.youcode.surveyit.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EditionRepository extends JpaRepository<Edition, Long> {

}
