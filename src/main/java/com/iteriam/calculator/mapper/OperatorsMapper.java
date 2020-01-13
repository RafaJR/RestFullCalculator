package com.iteriam.calculator.mapper;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iteriam.calculator.constants.CaculatorTracer;
import com.iteriam.calculator.model.InputOperators;
import com.iteriam.calculator.model.calculation.BigDecimalOperators;
import com.iteriam.calculator.model.calculation.DoubleOperators;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Mapper for conversion from 'String' input
 * parameters to arithmeic operable parameters
 */

@Component("OperatorsMapper")
public class OperatorsMapper {
    
    @Autowired
    private CaculatorTracer tracer;

    /**
     * @param inputOperators
     * @return DoubleOperators
     * @throws NumberFormatException
     * Return the input operators as 'double' privitives
     * for arithmetic operations 
     */
    public DoubleOperators toDoubleMapper(InputOperators inputOperators) throws NumberFormatException {
	
	tracer.trace(String.format(CaculatorTracer.MAP_TO_DOUBLE, inputOperators.toString()));
	
	return new DoubleOperators(Double.valueOf(inputOperators.getOperator1()),
		Double.valueOf(inputOperators.getOperator2()), Long.valueOf(inputOperators.getAccuracy()),
		inputOperators.getOperation());

    }
    
    /**
     * @param inputOperators
     * @return BigDecimalOperators
     * @throws NumberFormatException
     * Return the input operators as 'BigDecimal' objects
     * for arithmetic operations with large numbers
     */
    public BigDecimalOperators toBigDecimalMapper(InputOperators inputOperators) throws NumberFormatException {
	
	tracer.trace(String.format(CaculatorTracer.MAP_TO_BIG_DECIMAL, inputOperators.toString()));
	
	return new BigDecimalOperators(new BigDecimal(inputOperators.getOperator1()),
		new BigDecimal(inputOperators.getOperator2()), Long.valueOf(inputOperators.getAccuracy()),
		inputOperators.getOperation());

    }

}
