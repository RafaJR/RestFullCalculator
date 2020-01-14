package com.iteriam.calculator.validation;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Unitary test for input data validation support methods
 */
class ValidationSupportTest {
    @Test 
    public void checkIntegerValueAsStringTest() {
	
	assertTrue(ValidationSupport.checkIntegerValueAsString("1"));
	assertTrue(ValidationSupport.checkIntegerValueAsString("+1"));
	assertTrue(ValidationSupport.checkIntegerValueAsString("-1"));
	assertTrue(ValidationSupport.checkIntegerValueAsString(String.valueOf(Long.MAX_VALUE)));
	assertTrue(ValidationSupport.checkIntegerValueAsString(String.valueOf(Long.MIN_VALUE)));
	assertTrue(ValidationSupport.checkIntegerValueAsString("+9837458972397856875467464534523465344534"));
	assertTrue(ValidationSupport.checkIntegerValueAsString("-9837458972397856875467464534523465344534"));
	assertTrue(ValidationSupport.checkIntegerValueAsString("9837458972397856875467464534523465344534"));	
	
	assertFalse(ValidationSupport.checkIntegerValueAsString("a"));
	assertFalse(ValidationSupport.checkIntegerValueAsString("0.75"));
	assertFalse(ValidationSupport.checkIntegerValueAsString("0,75"));
	assertFalse(ValidationSupport.checkDoubleValueAsString("5 5"));
	assertFalse(ValidationSupport.checkIntegerValueAsString(""));
	assertFalse(ValidationSupport.checkIntegerValueAsString(null));
    }
    
    @Test
    public void checkDoubleValueAsStringTest() {

	assertTrue(ValidationSupport.checkDoubleValueAsString("5"));
	assertTrue(ValidationSupport.checkDoubleValueAsString("-5"));
	assertTrue(ValidationSupport.checkDoubleValueAsString("+5"));
	assertTrue(ValidationSupport.checkDoubleValueAsString("0.75"));
	assertTrue(ValidationSupport.checkDoubleValueAsString("-0.75"));
	assertTrue(ValidationSupport.checkDoubleValueAsString("+0.75"));
	assertTrue(ValidationSupport.checkDoubleValueAsString("0,75"));
	assertTrue(ValidationSupport.checkDoubleValueAsString("+0.000000000000001"));
	assertTrue(ValidationSupport.checkDoubleValueAsString("9837458972397856875467464534523465344534,9876785"));
	
	assertFalse(ValidationSupport.checkDoubleValueAsString("a"));
	assertFalse(ValidationSupport.checkDoubleValueAsString("5 5"));
	assertFalse(ValidationSupport.checkDoubleValueAsString(""));
	assertFalse(ValidationSupport.checkDoubleValueAsString(null));

    }
    
    @Test
    public void checkAccuracyTest() {
	
	assertTrue(ValidationSupport.checkAccuracy(""));
	assertTrue(ValidationSupport.checkAccuracy(null));
	assertTrue(ValidationSupport.checkAccuracy("1"));
	assertTrue(ValidationSupport.checkAccuracy("+1"));
	assertTrue(ValidationSupport.checkAccuracy("-1"));
	assertTrue(ValidationSupport.checkAccuracy(String.valueOf(Long.MAX_VALUE)));
	assertTrue(ValidationSupport.checkAccuracy(String.valueOf(Long.MIN_VALUE)));
	assertTrue(ValidationSupport.checkAccuracy("+9837458972397856875467464534523465344534"));
	assertTrue(ValidationSupport.checkAccuracy("-9837458972397856875467464534523465344534"));
	assertTrue(ValidationSupport.checkAccuracy("9837458972397856875467464534523465344534"));	
	
	assertFalse(ValidationSupport.checkAccuracy("a"));
	assertFalse(ValidationSupport.checkAccuracy("0.75"));
	assertFalse(ValidationSupport.checkAccuracy("0,75"));
	assertFalse(ValidationSupport.checkAccuracy("5 5"));	

    }

}
