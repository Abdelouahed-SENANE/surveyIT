package ma.youcode.surveyit.util.annotations.interfaces;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import ma.youcode.surveyit.util.annotations.implementations.ExistValidator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = ExistValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD , ElementType.FIELD , ElementType.PARAMETER})
public @interface Exist {
    String message() default "Entity does not exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default{};

    Class<?> entity();
}
