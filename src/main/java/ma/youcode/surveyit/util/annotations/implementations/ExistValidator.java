package ma.youcode.surveyit.util.annotations.implementations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ma.youcode.surveyit.repository.OwnerRepository;
import ma.youcode.surveyit.repository.SurveyRepository;
import ma.youcode.surveyit.util.annotations.interfaces.Exist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.tokens.Token;

public class ExistValidator implements ConstraintValidator<Exist, Long> {

    @Autowired
    private ApplicationContext appContext;

    private Class<?> entityClass;

    @Override
    public void initialize(Exist constraintAnnotation) {
        this.entityClass = constraintAnnotation.entity();
    }
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        if (id == null) {
            return true;
        }
        JpaRepository<? , Long> repository = getCurrentRepository();
        return repository.existsById(id);
    }

    private JpaRepository<? , Long> getCurrentRepository(){
        return switch (entityClass.getSimpleName()) {
            case "Owner" -> appContext.getBean(OwnerRepository.class);
            case "Survey" -> appContext.getBean(SurveyRepository.class);
            default -> throw new IllegalArgumentException("No repository Found for this class : " + entityClass);
        };

    }








}
