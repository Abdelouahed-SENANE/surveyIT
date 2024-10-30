package ma.youcode.surveyit.repository;

import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.entity.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyRepository extends JpaRepository<Survey, Long> {

}
