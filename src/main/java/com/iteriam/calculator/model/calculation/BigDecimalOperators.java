package com.iteriam.calculator.model.calculation;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import com.iteriam.calculator.model.Operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Model class for big number calculations
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BigDecimalOperators {

    private BigDecimal operator1;
    private BigDecimal operator2;
    private long accuracy;	
    private Operation operation;
    
}
