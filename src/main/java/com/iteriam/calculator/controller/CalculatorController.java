package com.iteriam.calculator.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.iteriam.calculator.constants.CaculatorTracer;
import com.iteriam.calculator.model.InputOperators;
import com.iteriam.calculator.service.ICalculatorService;
//import io.corp.calculator.*;

/**
 * @author Rafael Jiménez Reina 
 * @email rafael.jimenez.reina@gmail.com
 * Main controller for dealing with arithmetic operations requests
 */
@RestController
@Validated
@RequestMapping("/calculator")
public class CalculatorController {
    
    @Autowired
    private CaculatorTracer tracer;
    
    @Autowired
    private ICalculatorService calculatorService;

    /**
     * @param inputOperators
     * @return ResponseEntity: The result of the requested operation
     * with the precision indicated.
     */
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    // Input parametres validated by 'javax.validation' custom annotations in Input Operators.
    public ResponseEntity<?> executeArithmeticOperation(@RequestBody @NotNull @Valid InputOperators inputOperators) {
	
	tracer.trace(String.format(CaculatorTracer.REQUEST, inputOperators.toString()));
	
	inputOperators.postFormat();
	
	return new ResponseEntity<String>(
		calculatorService.executeArithmeticOperation(inputOperators) ,
		HttpStatus.OK);

    }

}
