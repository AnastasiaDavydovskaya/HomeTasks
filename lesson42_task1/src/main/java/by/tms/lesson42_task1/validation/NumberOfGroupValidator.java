package by.tms.lesson42_task1.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NumberOfGroupValidator implements ConstraintValidator<NumberOfGroup, String> {


    @Override
    public boolean isValid(String numberOfGroup, ConstraintValidatorContext context) {
        return numberOfGroup != null
                && numberOfGroup.length() > 3
                && numberOfGroup.length() < 20
                && numberOfGroup.contains("-");
    }
}
