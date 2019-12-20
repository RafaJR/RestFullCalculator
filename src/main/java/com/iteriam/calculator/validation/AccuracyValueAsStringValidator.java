package com.iteriam.calculator.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Accuracy (integer numbers) validation constraint.
 */
public class AccuracyValueAsStringValidator implements ConstraintValidator<AccuracyValueAsStringConstraint, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	
	// Support method call for accuracy validation
	return ValidationSupport.checkAccuracy(value);
    }

}