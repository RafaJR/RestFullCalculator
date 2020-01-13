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

    public static final  String DIVIDE_ARITHMETIC_EXCEPTION = "An Arithmetic exception caused by a no exact representable decimal result happens when trying to divide %1s between %2s, " +
	    "so the final result is going to be rounded following a \"HALF_UP\" method.";
    public static final String MULTIPLICATION_ARITHMETIC_EXCEPTION = "An Arithmetic exception caused by a no exact representable decimal result happens when trying to multiply %1s by %2s, " +
	    "so the final result is going to be rounded following a \"HALF_UP\" method.";
    public static final String SUBTRACTION_ARITHMETIC_EXCEPTION = "An Arithmetic exception caused by a no exact representable decimal result happens when trying to subtract %2s by %1s, " +
	    "so the final result is going to be rounded following a \"HALF_UP\" method.";
    public static final String ADDITION_ARITHMETIC_EXCEPTION = "An Arithmetic exception caused by a no exact representable decimal result happens when trying to add %1s to %2s, " +
	    "so the final result is going to be rounded following a \"HALF_UP\" method.";
    public static final String REQUEST = "Request recibed for arithmetic operation with parameters: %1s";
    public static final String MAP_TO_DOUBLE = "Converting input data (%1s) to double operators to enable arithmetic operations";
    public static final String MAP_TO_BIG_DECIMAL = "Converting input data (%1s) to Big Decimal operators to enable large numbers arithmetic operations";
    public static final String POST_FORMAT = "Correcting the input data format to guarantee the conversion to arithmetic operable numbers.";
    public static final String DOUBLE_OPERATOR_CHECK = "Checking if the input parameter \"%1s\" is convertible to Dobule number.";
    public static final String DOUBLE_OPERATORS_OPERATION = "Executing the arithmetic operation with double operators";
    public static final String BIG_DECIMALS_OPERATORS_OPERATION = "Executing the arithmetic operation with big decimal operators";
    public static final String NOT_OPERATION_FOUND = "The indicated operation is not recogniced";
    public static final String DOUBLE_ADDITION = "Executing \"ADDITION\" operation for double values %1s adn %2s";
    public static final String BIG_DECIMAL_ADDITION = "Executing \"ADDITION\" operation for big decimal values %1s adn %2s";
    public static final String DOUBLE_SUBTRACTION = "Executing \"SUBTRACTION\" operation for double values %1s adn %2s";
    public static final String BIG_DECIMAL_SUBTRACTION = "Executing \"SUBTRACTION\" operation for big decimal values %1s adn %2s";
    public static final String DOUBLE_MULTIPLICATION = "Executing \"MULTIPLICATION\" operation for double values %1s adn %2s";
    public static final String BIG_DECIMAL_MULTIPLICATION = "Executing \"MULTIPLICATION\" operation for big decimal values %1s adn %2s";
    public static final String DOUBLE_DIVISION = "Executing \"DIVISION\" operation for double values %1s adn %2s";
    public static final String BIG_DECIMAL_DIVISION = "Executing \"DIVISION\" operation for big decimal values %1s adn %2s";
    public static final String DOUBLE_CHECK = "Checking if value \"%1s\" is convertible to operable double value";
    public static final String ACCURACY_CHECK = "Checking if value \"%1s\" is convertible to integer or valid accuracy value";

}