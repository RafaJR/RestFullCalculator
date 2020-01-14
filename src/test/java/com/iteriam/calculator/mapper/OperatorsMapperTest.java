package com.iteriam.calculator.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.iteriam.calculator.model.InputOperators;
import com.iteriam.calculator.model.Operation;
import com.iteriam.calculator.model.calculation.BigDecimalOperators;
import com.iteriam.calculator.model.calculation.DoubleOperators;

/**
 * @author Rafael Jiménez Reina
 * @email rafael.jimenez.reina@gmail.com
 * Integration test for input data validation support methods
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class OperatorsMapperTest {

    @Autowired
    OperatorsMapper operatorsMapper;

    @Test
    void toDoubleMapperTest() {

	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("a", "10", "2", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("10", "a", "2", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("10", "10", "a", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("10", "10", "1.2", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("10.25", "10,2", "2", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("1 0", "10.2", "2", Operation.ADDITION));
	});

	assertEquals(new DoubleOperators(10.2d, 10.2d, 2l, Operation.ADDITION),
		operatorsMapper.toDoubleMapper(new InputOperators("10.2", "10.2", "2", Operation.ADDITION)));
	assertEquals(new DoubleOperators(10.2d, -10.2d, 2l, Operation.ADDITION),
		operatorsMapper.toDoubleMapper(new InputOperators("+10.2", "-10.2", "2", Operation.ADDITION)));
    }

    @Test
    void toBigDecimalMapperTest() {

	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("a", "10", "2", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("10", "a", "2", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("10", "10", "a", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("10", "10", "1.2", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("10.25", "10,2", "2", Operation.ADDITION));
	});
	assertThrows(NumberFormatException.class, () -> {
	    operatorsMapper.toDoubleMapper(new InputOperators("1 0", "10.2", "2", Operation.ADDITION));
	});

	String bigDecimal1 = "1.66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666";
	String bigDecimal2 = "9.22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222";
	String bigDecimal3 = "+1.66666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666";
	String bigDecimal4 = "-9.22222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222222";

	assertEquals(
		new BigDecimalOperators(new BigDecimal(bigDecimal1), new BigDecimal(bigDecimal2), 2l,
			Operation.ADDITION),
		operatorsMapper
			.toBigDecimalMapper(new InputOperators(bigDecimal1, bigDecimal2, "2", Operation.ADDITION)));
	assertEquals(
		new BigDecimalOperators(new BigDecimal(bigDecimal3), new BigDecimal(bigDecimal4), 2l,
			Operation.ADDITION),
		operatorsMapper
			.toBigDecimalMapper(new InputOperators(bigDecimal3, bigDecimal4, "2", Operation.ADDITION)));
    }

}
