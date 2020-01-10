package com.iteriam.calculator.constants;

import org.springframework.stereotype.Component;
import io.corp.calculator.TracerImpl;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com Operaions of arithmetic calculation
 *        service
 */
@Component
public final class CaculatorTracer extends TracerImpl {    

    public final static String DIVIDE_ARITHMETIC_EXCEPTION = "An Arithmetic exception caused by a no exact representable decimal result happens when trying to divide %1s between %2s, " +
	    "so the final result is going to be rounded following a \"HALF_UP\" method.";
    public final static String MULTIPLICATION_ARITHMETIC_EXCEPTION = "An Arithmetic exception caused by a no exact representable decimal result happens when trying to multiply %1s by %2s, " +
	    "so the final result is going to be rounded following a \"HALF_UP\" method.";
    public final static String SUBTRACTION_ARITHMETIC_EXCEPTION = "An Arithmetic exception caused by a no exact representable decimal result happens when trying to subtract %2s by %1s, " +
	    "so the final result is going to be rounded following a \"HALF_UP\" method.";
    public final static String ADDITION_ARITHMETIC_EXCEPTION = "An Arithmetic exception caused by a no exact representable decimal result happens when trying to add %1s to %2s, " +
	    "so the final result is going to be rounded following a \"HALF_UP\" method.";    

}