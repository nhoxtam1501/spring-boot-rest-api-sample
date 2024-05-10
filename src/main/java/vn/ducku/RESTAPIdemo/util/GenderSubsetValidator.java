package vn.ducku.RESTAPIdemo.util;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class GenderSubsetValidator implements ConstraintValidator<GenderSubset, Enum<?>> {
    private Gender[] genders;

    @Override
    public void initialize(GenderSubset constraintAnnotation) {
        this.genders = constraintAnnotation.anyOf();
    }

    @Override
    public boolean isValid(Enum<?> value, ConstraintValidatorContext constraintValidatorContext) {
        return value == null || Arrays.asList(genders).contains(value);
    }
}
