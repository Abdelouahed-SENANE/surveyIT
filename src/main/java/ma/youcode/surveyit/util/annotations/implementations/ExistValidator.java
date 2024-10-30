package ma.youcode.surveyit.util.annotations.implementations;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ma.youcode.surveyit.util.annotations.interfaces.Exists;

public class ExistValidator implements ConstraintValidator<Exists, Long> {

    @PersistenceContext
    private EntityManager manager;

    private Class<?> entityClass;

    @Override
    public void initialize(Exists constraintAnnotation) {
        this.entityClass = constraintAnnotation.entity();
    }

    @Override
    public boolean isValid(Long id, ConstraintValidatorContext context) {
        if (id == null) {
            return true;
        }

        boolean exists = manager.find(entityClass, id) != null;

        if(!exists){
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addPropertyNode("id") // Or the relevant property name
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            return false;
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(entityClass.getSimpleName() + " not found with id " + id)
//                    .addConstraintViolation();
        }
        return true;
    }


}
