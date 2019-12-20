package com.iteriam.calculator.validation;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Unitary test for input data validation support methods
 */
class ValidationSupportTest {
    @Test 
    public void checkIntegerValueAsStringTest() {
	
	Assert.assertTrue(ValidationSupport.checkIntegerValueAsString("1"));
	Assert.assertTrue(ValidationSupport.checkIntegerValueAsString("+1"));
	Assert.assertTrue(ValidationSupport.checkIntegerValueAsString("-1"));
	Assert.assertTrue(ValidationSupport.checkIntegerValueAsString(String.valueOf(Long.MAX_VALUE)));
	Assert.assertTrue(ValidationSupport.checkIntegerValueAsString(String.valueOf(Long.MIN_VALUE)));
	Assert.assertTrue(ValidationSupport.checkIntegerValueAsString("+9837458972397856875467464534523465344534"));
	Assert.assertTrue(ValidationSupport.checkIntegerValueAsString("-9837458972397856875467464534523465344534"));
	Assert.assertTrue(ValidationSupport.checkIntegerValueAsString("9837458972397856875467464534523465344534"));	
	
	Assert.assertFalse(ValidationSupport.checkIntegerValueAsString("a"));
	Assert.assertFalse(ValidationSupport.checkIntegerValueAsString("0.75"));
	Assert.assertFalse(ValidationSupport.checkIntegerValueAsString("0,75"));
	Assert.assertFalse(ValidationSupport.checkDoubleValueAsString("5 5"));
	Assert.assertFalse(ValidationSupport.checkIntegerValueAsString(""));
	Assert.assertFalse(ValidationSupport.checkIntegerValueAsString(null));
    }
    
    @Test
    public void checkDoubleValueAsStringTest() {

	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("5"));
	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("-5"));
	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("+5"));
	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("0.75"));
	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("-0.75"));
	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("+0.75"));
	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("0,75"));
	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("+0.000000000000001"));
	Assert.assertTrue(ValidationSupport.checkDoubleValueAsString("9837458972397856875467464534523465344534,9876785"));
	
	Assert.assertFalse(ValidationSupport.checkDoubleValueAsString("a"));
	Assert.assertFalse(ValidationSupport.checkDoubleValueAsString("5 5"));
	Assert.assertFalse(ValidationSupport.checkDoubleValueAsString(""));
	Assert.assertFalse(ValidationSupport.checkDoubleValueAsString(null));

    }
    
    @Test
    public void checkAccuracyTest() {
	
	Assert.assertTrue(ValidationSupport.checkAccuracy(""));
	Assert.assertTrue(ValidationSupport.checkAccuracy(null));
	Assert.assertTrue(ValidationSupport.checkAccuracy("1"));
	Assert.assertTrue(ValidationSupport.checkAccuracy("+1"));
	Assert.assertTrue(ValidationSupport.checkAccuracy("-1"));
	Assert.assertTrue(ValidationSupport.checkAccuracy(String.valueOf(Long.MAX_VALUE)));
	Assert.assertTrue(ValidationSupport.checkAccuracy(String.valueOf(Long.MIN_VALUE)));
	Assert.assertTrue(ValidationSupport.checkAccuracy("+9837458972397856875467464534523465344534"));
	Assert.assertTrue(ValidationSupport.checkAccuracy("-9837458972397856875467464534523465344534"));
	Assert.assertTrue(ValidationSupport.checkAccuracy("9837458972397856875467464534523465344534"));	
	
	Assert.assertFalse(ValidationSupport.checkAccuracy("a"));
	Assert.assertFalse(ValidationSupport.checkAccuracy("0.75"));
	Assert.assertFalse(ValidationSupport.checkAccuracy("0,75"));
	Assert.assertFalse(ValidationSupport.checkAccuracy("5 5"));	

    }

}
