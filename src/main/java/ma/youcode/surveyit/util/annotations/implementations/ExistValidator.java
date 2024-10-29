package ma.youcode.surveyit.util.annotations.implementations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ma.youcode.surveyit.repository.OwnerRepository;
import ma.youcode.surveyit.util.annotations.interfaces.Exist;
import org.springframework.beans.factory.annotation.Autowired;

public class ExistValidator implements ConstraintValidator<Exist , Long> {

    @Autowired
    private OwnerRepository ownerRepository;

//    @Autowired
//    private OwnerRepository ownerRepository;

    public boolean isValid(Long id , ConstraintValidatorContext context){
        if (id == null) {return true;}
        return ownerRepository.existsById(id);
    }
}
