package org.bank.sbi.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StatusValidator.class)
@Documented
public @interface IsValidStatus {

    String[] listOfValidStatus() default {"Active", "InActive"};

    String message() default "Please provide valid status. Accepted Values are Active or Inactive";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
