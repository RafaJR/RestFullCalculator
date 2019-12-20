package com.iteriam.calculator.service;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Operaions of arithmetic calculation interface
 * @implementations: CalculatorServiceImpl
 */
import com.iteriam.calculator.model.InputOperators;

public interface ICalculatorService {
    
    /**
     * @param inputOperators
     * @return String: The result of the requested operation
     * with the precision indicated.
     */
    public String executeArithmeticOperation(InputOperators inputOperators);

}
