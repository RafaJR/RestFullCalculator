package com.iteriam.calculator.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * unitary test for input input data methods
 */
class InputOperatorsTest {

    @Test
    void postFormatTest() {
	
	InputOperators inputOperators = new InputOperators("+1,2","-1.5","2", Operation.ADDITION);
	inputOperators.postFormat();
	assertEquals(new InputOperators("1.2","-1.5","2", Operation.ADDITION), inputOperators);
	
	inputOperators = new InputOperators("23","34", null, Operation.ADDITION);
	inputOperators.postFormat();
	assertEquals(new InputOperators("23","34","-1", Operation.ADDITION), inputOperators);
	
	inputOperators = new InputOperators("23","34", "", Operation.ADDITION);
	inputOperators.postFormat();
	assertEquals(new InputOperators("23","34","-1", Operation.ADDITION), inputOperators);
	
    }
    
    @Test
    void isDoubleOperable() {
	
	InputOperators inputOperators = new InputOperators("1.2", "-1.5", "2", Operation.ADDITION);
	assertTrue(inputOperators.isDoubleOperable());
	
	String bigDecimal1 = "1.66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666";
	String bigDecimal2 = "9.22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222";
	String bigDecimal3 = "98437289723698472389479823749823687426847238947823";
	String bigDecimal4 = "83487239873489236748923672739846982734687326437644";
	
	inputOperators = new InputOperators(bigDecimal1, bigDecimal2, "2", Operation.ADDITION);
	assertFalse(inputOperators.isDoubleOperable());
	
	inputOperators = new InputOperators("1", bigDecimal2, "2", Operation.ADDITION);
	assertFalse(inputOperators.isDoubleOperable());
	
	inputOperators = new InputOperators(bigDecimal1, "2", "2", Operation.ADDITION);
	assertFalse(inputOperators.isDoubleOperable());
	
	inputOperators = new InputOperators(bigDecimal3, "2", "2", Operation.ADDITION);
	assertFalse(inputOperators.isDoubleOperable());
	
	inputOperators = new InputOperators("3", bigDecimal4, "2", Operation.ADDITION);
	assertFalse(inputOperators.isDoubleOperable());
	
    }

}
