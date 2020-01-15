package com.iteriam.calculator.service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iteriam.calculator.model.InputOperators;
import com.iteriam.calculator.model.Operation;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com integration test for Calculator Service
 *        methods
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class CalculatorServiceImplTest {

    @Autowired
    private CalculatorServiceImpl service;

    @Test
    void executeArithmeticOperationTest() {

	String bigDecimal1 = "1.66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666";
	String bigDecimal2 = "9.22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222";
	String bigDecimal3 = "98437289723698472389479823749823687426847238947823";
	String bigDecimal4 = "83487239873489236748923672739846982734687326437644";

	assertEquals("13.0", service.executeArithmeticOperation(new InputOperators("9", "4", "2", Operation.ADDITION)));
	assertEquals("5.0",
		service.executeArithmeticOperation(new InputOperators("9", "4", "2", Operation.SUBTRACTION)));
	assertEquals("36.0",
		service.executeArithmeticOperation(new InputOperators("9", "4", "2", Operation.MULTIPLICATION)));
	assertEquals("2.25", service.executeArithmeticOperation(new InputOperators("9", "4", "2", Operation.DIVISION)));

	assertEquals("13.25",
		service.executeArithmeticOperation(new InputOperators("9.12", "4.13", "2", Operation.ADDITION)));
	assertEquals("4.989999999999999",
		service.executeArithmeticOperation(new InputOperators("9.12", "4.13", "2", Operation.SUBTRACTION)));
	assertEquals("37.6656",
		service.executeArithmeticOperation(new InputOperators("9.12", "4.13", "2", Operation.MULTIPLICATION)));
	assertEquals("2.208232445520581",
		service.executeArithmeticOperation(new InputOperators("9.12", "4.13", "2", Operation.DIVISION)));

	assertEquals(
		"347.01086666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666",
		service.executeArithmeticOperation(
			new InputOperators(bigDecimal1, "345.3442", "2", Operation.ADDITION)));
	assertEquals(
		"336.12197777777777777777777777777777777777777777777777777777777777777777777777777777777777777777778",
		service.executeArithmeticOperation(
			new InputOperators("345.3442", bigDecimal2, "2", Operation.SUBTRACTION)));
	assertEquals(
		"98437289723698472389479823749823687426847238947824.66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666",
		service.executeArithmeticOperation(
			new InputOperators(bigDecimal1, bigDecimal3, "2", Operation.ADDITION)));
	assertEquals("181924529597187709138403496489670670161534565385467", service
		.executeArithmeticOperation(new InputOperators(bigDecimal3, bigDecimal4, "2", Operation.ADDITION)));

    }

}