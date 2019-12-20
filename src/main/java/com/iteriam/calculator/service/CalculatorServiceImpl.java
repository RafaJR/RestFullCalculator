package com.iteriam.calculator.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iteriam.calculator.mapper.OperatorsMapper;
import com.iteriam.calculator.model.InputOperators;
import com.iteriam.calculator.model.calculation.BigDecimalOperators;
import com.iteriam.calculator.model.calculation.DoubleOperators;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Operaions of arithmetic calculation service
 */
@Service
public class CalculatorServiceImpl implements ICalculatorService {

    @Autowired
    // Operable number conversion mapper
    OperatorsMapper operatorsMapper;
    
    private final static String ILLEGAL_OPERATION = "Illegal operation";

    @Override
    /**
     * @param inputOperators
     * @return String: The result of the requested operation with the precision
     *         indicated.
     */
    public String executeArithmeticOperation(InputOperators inputOperators) {

	// Ensure that the input operators are convertible to operable numbers.
	inputOperators.setDecimalSeparator();
	String result = "";

	// The 'BigDecimal' object only will be used if input parameters are really so
	// large for 'double' primitives
	if (inputOperators.isDoubleOperable()) {
	    // Conversion to 'double' operators
	    DoubleOperators doubleOperators = operatorsMapper.toDoubleMapper(inputOperators);
	    // Arithmetic operations method for 'double' parameters
	    result = executeArithmeticOperation(doubleOperators);

	} else {
	    // Conversion to 'BigInteger' operators
	    BigDecimalOperators bigDecimalOperators = operatorsMapper.toBigDecimalMapper(inputOperators);
	    // Arithmetic operations method for 'BigInteger' parameters
	    result = executeArithmeticOperation(bigDecimalOperators);
	}

	return result;
    }

    /**
     * @param doubleOperators
     * @return String Arithmetic operations method for 'double' parameters
     */
    private String executeArithmeticOperation(DoubleOperators doubleOperators) {

	String result = "";

	switch (doubleOperators.getOperation()) {

	case ADDITION:
	    result = this.addition(doubleOperators.getOperator1(), doubleOperators.getOperator2());
	    break;
	case SUBTRACTION:
	    result = this.subtraction(doubleOperators.getOperator1(), doubleOperators.getOperator2());
	    break;
	case MULTIPLICATION:
	    result = this.multiplication(doubleOperators.getOperator1(), doubleOperators.getOperator2());
	    break;
	case DIVISION:
	    result = this.division(doubleOperators.getOperator1(), doubleOperators.getOperator2());
	    break;
	default:
	    result = "Lost operation.";
	    break;

	}

	return result;

    }

    /**
     * @param doubleOperators
     * @return String Arithmetic operations method for 'BigInteger' parameters
     */
    private String executeArithmeticOperation(BigDecimalOperators bigDecimalOperators) {

	String result = "";

	switch (bigDecimalOperators.getOperation()) {

	case ADDITION:
	    result = this.addition(bigDecimalOperators.getOperator1(), bigDecimalOperators.getOperator2());
	    break;
	case SUBTRACTION:
	    result = this.subtraction(bigDecimalOperators.getOperator1(), bigDecimalOperators.getOperator2());
	    break;
	case MULTIPLICATION:
	    result = this.multiplication(bigDecimalOperators.getOperator1(), bigDecimalOperators.getOperator2());
	    break;
	case DIVISION:
	    result = this.division(bigDecimalOperators.getOperator1(), bigDecimalOperators.getOperator2());
	    break;
	default:
	    result = "Lost operation.";
	    break;
	}

	return result;

    }

    /**
     * @param operator1
     * @param operator2
     * @return The 'double' parameters sum as String
     */
    private String addition(double operator1, double operator2) {

	return String.valueOf(Double.sum(operator1, operator2));

    }

    /**
     * @param operator1
     * @param operator2
     * @return The 'BigDecimal' parameters sum as String
     */
    private String addition(BigDecimal operator1, BigDecimal operator2) {

	return operator1.add(operator2).toString();

    }

    /**
     * @param operator1
     * @param operator2
     * @return The 'double' parameters subtraction as String
     */
    private String subtraction(double operator1, double operator2) {

	return String.valueOf(operator1 - operator2);

    }

    /**
     * @param operator1
     * @param operator2
     * @return The 'BigDecimal' parameters subtraction as String
     */
    private String subtraction(BigDecimal operator1, BigDecimal operator2) {

	return operator1.subtract(operator2).toString();

    }

    /**
     * @param operator1
     * @param operator2
     * @return The 'double' parameters multiplication as String
     */
    private String multiplication(double operator1, double operator2) {

	return String.valueOf(operator1 * operator2);

    }

    /**
     * @param operator1
     * @param operator2
     * @return The 'BigDecimal' parameters multiplication as String
     */
    private String multiplication(BigDecimal operator1, BigDecimal operator2) {

	return operator1.multiply(operator2).toString();

    }

    /**
     * @param operator1
     * @param operator2
     * @return The 'double' parameters division as String
     */
    private String division(double operator1, double operator2) {

	return operator2 != 0 ? 
		String.valueOf(operator1 / operator2) :
		ILLEGAL_OPERATION;

    }

    /**
     * @param operator1
     * @param operator2
     * @return The 'BigDecimal' parameters division as String
     */
    private String division(BigDecimal operator1, BigDecimal operator2) {

	return operator2.compareTo(new BigDecimal(0)) != 0 ?
		operator1.divide(operator2).toString() :
		ILLEGAL_OPERATION;

    }
}
