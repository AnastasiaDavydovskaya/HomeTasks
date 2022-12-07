package by.tms.lesson41_task1.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NumberOfGroupValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NumberOfGroup {

    String message() default "Invalid number of group value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
