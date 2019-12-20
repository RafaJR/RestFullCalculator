package com.iteriam.calculator.validation;

/**
 * @author Rafael Jiménez Reina
	Validation methods to check the numeric format of the input Strings before it's real number conversion to operate.
 */
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ValidationSupport {

    // Regular expression to check the 'integer convertible format' of a String
    private static final String regexInteger = "(^(-|\\+)?\\d+$)";
    // Regular expression to check the 'real number convertible format' of a String
    private static final String regexDecimal = "^(-|\\+)?\\d*(\\.|\\,)\\d+$";
    // Regular expression to check the 'integer or real number convertible format' of a String
    private static final String regexDouble = regexDecimal + "|" + regexInteger;

    /**
     * @param String strInteger
     * @return true if the String format is 'Integer convertible', false otherwise
     */
    public static boolean checkIntegerValueAsString(String strInteger) {

	return !StringUtils.isEmpty(strInteger) && Pattern.compile(regexInteger).matcher(strInteger).matches();
    }
    
    /**
     * @param String strDouble
     * @return true if the String format is 'Real number convertible', false otherwise
     */
    public static boolean checkDoubleValueAsString(String strDouble) {

	return !StringUtils.isEmpty(strDouble) && Pattern.compile(regexDouble).matcher(strDouble).matches();

    }
    
    /**
     * @param String accuracy
     * @return true if the String is null or empty or it's format is 'Integer convertible', false otherwise
     */
    public static boolean checkAccuracy(String accuracy) {

	return StringUtils.isEmpty(accuracy) || checkIntegerValueAsString(accuracy);

    }

}
