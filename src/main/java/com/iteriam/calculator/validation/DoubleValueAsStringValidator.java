package com.iteriam.calculator.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Operators (decimal numbers) validation constraint.
 */
public class DoubleValueAsStringValidator implements ConstraintValidator<DoubleValueAsStringConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

	// Support method call for operators validation
	return ValidationSupport.checkDoubleValueAsString(value);
    }

}