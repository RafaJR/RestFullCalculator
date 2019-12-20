package com.iteriam.calculator.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Interface for accuracy (integer numbers) validation constraint.
 * @implementations: AccuracyValueAsStringValidator
 */
@Documented
@Constraint(validatedBy = AccuracyValueAsStringValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AccuracyValueAsStringConstraint {
    String message() default "There is an error at the accuracy field. The accuracy is not a mandatory field, but if you introduce it in the request, it must be numeric and integer.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
