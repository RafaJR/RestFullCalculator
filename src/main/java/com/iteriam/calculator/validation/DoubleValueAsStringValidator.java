package com.iteriam.calculator.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.iteriam.calculator.constants.CaculatorTracer;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Operators (decimal numbers) validation constraint.
 */
public class DoubleValueAsStringValidator implements ConstraintValidator<DoubleValueAsStringConstraint, String> {
    
    @Autowired
    private CaculatorTracer tracer;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

	tracer.trace(String.format(CaculatorTracer.DOUBLE_CHECK, value));
	// Support method call for operators validation
	return ValidationSupport.checkDoubleValueAsString(value);
    }

}