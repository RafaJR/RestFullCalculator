package com.iteriam.calculator.model;

import com.iteriam.calculator.validation.DoubleValueAsStringConstraint;

import javax.annotation.PostConstruct;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.iteriam.calculator.constants.CaculatorTracer;
import com.iteriam.calculator.validation.AccuracyValueAsStringConstraint;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Input data for arithmetic operations operator1
 * and operator2: operators accuracy: level of precission or number of
 * decimals to return the result operation: available arithmetic options
 * (adition, subtract, multiplication and division)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InputOperators {
    
//    @Autowired
//    private CaculatorTracer tracer;

    private static final String COMMA = ",";
    private static final String DOT = ".";
    private static final String POSSITIVE = "+";
    private static final String NEGATIVE = "-";
    private static final String BLANK = "";

    @NotNull
    @DoubleValueAsStringConstraint // Custom validation for operators: only decimal or integer numbers of any size, not null values allowed.
    private String operator1;
    @NotNull
    @DoubleValueAsStringConstraint // Custom validation for operators: only decimal or integer numbers of any size, not null values allowed. 
    private String operator2;
    @AccuracyValueAsStringConstraint // Custom validation for accuracy: only integer numbers of any size.
    private String accuracy;
    @NotNull
    private Operation operation; // Enum containing de available arithmetic operations (adition, subtract, multiplication and division), not null values allowed.

    /**
     * The 'comma' as decimal separator is allowed or input, but must be fixed
     * inmedatly after construction for number conversion.
     */
    @PostConstruct
    public void postFormat() {
	
//	tracer.trace(CaculatorTracer.POST_FORMAT);

	this.operator1 = operator1.replace(COMMA, DOT).replace(POSSITIVE, BLANK);
	this.operator2 = operator2.replace(COMMA, DOT).replace(POSSITIVE, BLANK);
	this.accuracy = StringUtils.isEmpty(accuracy) ? "-1" : this.accuracy;
    }

    /**
     * @return boolean Method to determine if the operators can be processed as
     *         'double' primitives.
     */
    public boolean isDoubleOperable() {

	return isDoubleOperable(this.operator1) && isDoubleOperable(this.operator2);

    }

    /**
     * @return boolean Method to determine if a operator can be processed as
     *         'double' primitives.
     */
    private boolean isDoubleOperable(String op) {
	
//	tracer.trace(String.format(CaculatorTracer.DOUBLE_OPERATOR_CHECK, op));

	int doubleMax = String.valueOf(Double.MAX_VALUE).getBytes().length;
	int doubleMin = String.valueOf(Double.MIN_VALUE).getBytes().length;
	int opereratorLenght = op.getBytes().length;
	
	return (!op.startsWith(NEGATIVE) && opereratorLenght <= doubleMax)
		|| (op.startsWith(NEGATIVE) && opereratorLenght <= doubleMin);
    }

}
