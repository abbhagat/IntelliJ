package org.bank.sbi.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class StatusValidator implements ConstraintValidator<IsValidStatus, String> {

    private List<String> listOfValidStatus;

    @Override
    public void initialize(IsValidStatus isValidStatus) {
        this.listOfValidStatus = Arrays.asList(isValidStatus.listOfValidStatus());
    }

    @Override
    public boolean isValid(String status, ConstraintValidatorContext constraintValidatorContext) {
        return listOfValidStatus.contains(status);
    }
}
