package ma.youcode.surveyit.util.annotations.implementations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ma.youcode.surveyit.entity.Owner;
import ma.youcode.surveyit.entity.Survey;
import ma.youcode.surveyit.repository.OwnerRepository;
import ma.youcode.surveyit.repository.SurveyRepository;
import ma.youcode.surveyit.util.annotations.interfaces.Exist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.tokens.Token;

import java.util.HashMap;
import java.util.Map;

public class ExistValidator implements ConstraintValidator<Exist, Long> {

    @Autowired
    private ApplicationContext appContext;

    private Class<?> entityClass;
    private static final Map<Class<?>, Class<? extends JpaRepository<?, ?>>> repositories = new HashMap<>();

    static {
        repositories.put(Owner.class , OwnerRepository.class);
        repositories.put(Survey.class , SurveyRepository.class);
    }
    @Override
    public void initialize(Exist constraintAnnotation) {
        this.entityClass = constraintAnnotation.entity();
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        if (id == null) {
            return true;
        }
        try {

            Class<? extends JpaRepository<? , ?>> repositoryClass = repositories.get(entityClass);
            if (repositoryClass == null) {
                throw new IllegalArgumentException("No repository found for " + entityClass.getSimpleName());
            }

            JpaRepository<? , Long> repository = (JpaRepository<?, Long>) appContext.getBean(repositoryClass);
            return repository.existsById(id);
        }catch (Exception e) {
            throw new RuntimeException("An unexpected error occurred while checking existence", e);
        }
    }


}
