package github.com.piotrpucolowski.taxicoordinators.validator;

import github.com.piotrpucolowski.taxicoordinators.model.UserEntity;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordConfirmationValidator implements ConstraintValidator<PasswordConfirmation, UserEntity> {

    @Override
    public void initialize(PasswordConfirmation constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserEntity user, ConstraintValidatorContext context) {
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
