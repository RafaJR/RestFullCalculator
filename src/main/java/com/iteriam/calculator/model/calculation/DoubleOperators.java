package com.iteriam.calculator.model.calculation;

import com.iteriam.calculator.model.Operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com 
 * Model class for fast calculations
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoubleOperators {
    
    private double operator1;
    private double operator2;
    private long accuracy;	
    private Operation operation;

}
