package com.iteriam.calculator.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.iteriam.calculator.constants.CaculatorTracer;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Accuracy (integer numbers) validation constraint.
 */
public class AccuracyValueAsStringValidator implements ConstraintValidator<AccuracyValueAsStringConstraint, String> {
    
    @Autowired
    private CaculatorTracer tracer;
    
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
	
	tracer.trace(String.format(CaculatorTracer.ACCURACY_CHECK, value));
	// Support method call for accuracy validation
	return ValidationSupport.checkAccuracy(value);
    }

}