package com.iteriam.calculator.controller;

import static org.junit.jupiter.api.Assertions.*;

import javax.validation.ConstraintViolationException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.iteriam.calculator.model.InputOperators;
import com.iteriam.calculator.model.Operation;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com integration test for Calculator
 *        Controller methods
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class CalculatorControllerTest {

    @Autowired
    private CalculatorController calculatorController;

    @SuppressWarnings("unchecked")
    @Test
    void test() {

	InputOperators inputOperators = new InputOperators("1", "1", "2", Operation.ADDITION);

	ResponseEntity<String> responseEntity = (ResponseEntity<String>) calculatorController
		.executeArithmeticOperation(inputOperators);
	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	assertEquals("2.0", responseEntity.getBody());

	assertThrows(ConstraintViolationException.class, () -> {
	    calculatorController.executeArithmeticOperation(new InputOperators("", "", "", Operation.ADDITION));
	});

	inputOperators = new InputOperators("1.5", "1.5", "2", Operation.ADDITION);
	responseEntity = (ResponseEntity<String>) calculatorController.executeArithmeticOperation(inputOperators);
	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	assertEquals("3.0", responseEntity.getBody());

	inputOperators = new InputOperators("1,5", "1,5", "2", Operation.ADDITION);
	responseEntity = (ResponseEntity<String>) calculatorController.executeArithmeticOperation(inputOperators);
	assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	assertEquals("3.0", responseEntity.getBody());

	String bigDecimal1 = "1.66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666";
	String bigDecimal2 = "9.22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222";
	String bigDecimal3 = "98437289723698472389479823749823687426847238947823";
	String bigDecimal4 = "83487239873489236748923672739846982734687326437644";

	assertEquals(
		"347.01086666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666",
		calculatorController
			.executeArithmeticOperation(
				new InputOperators(bigDecimal1, "345.3442", "2", Operation.ADDITION))
			.getBody().toString());
	assertEquals(
		"336.12197777777777777777777777777777777777777777777777777777777777777777777777777777777777777777778",
		calculatorController
			.executeArithmeticOperation(
				new InputOperators("345.3442", bigDecimal2, "2", Operation.SUBTRACTION))
			.getBody().toString());
	assertEquals(
		"98437289723698472389479823749823687426847238947824.66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666",
		calculatorController
			.executeArithmeticOperation(
				new InputOperators(bigDecimal1, bigDecimal3, "2", Operation.ADDITION))
			.getBody().toString());
	assertEquals("181924529597187709138403496489670670161534565385467", calculatorController
		.executeArithmeticOperation(new InputOperators(bigDecimal3, bigDecimal4, "2", Operation.ADDITION))
		.getBody().toString());
    }

}
