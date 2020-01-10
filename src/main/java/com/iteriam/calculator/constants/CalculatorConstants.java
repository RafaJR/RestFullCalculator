package com.iteriam.calculator.constants;

import java.math.MathContext;
import java.math.RoundingMode;

public final class CalculatorConstants {
    
    public final static String ILLEGAL_OPERATION = "Illegal operation";
    // Rounding scale for no exact representable decimal result in division operations
    public final static RoundingMode ROUDING_MODE = RoundingMode.HALF_EVEN;
    // Math context to prevent no representable decimals in arithmetic operations results
    public final static MathContext MATH_CONTEXT = MathContext.UNLIMITED;
    public final static String BLANK = "";

}
