package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExponentiationTest {

    @Test
    public void testIntegerExponentiation() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 64d, calculator.evaluateMathExpression("2^6"), 0.00001);

    }

    @Test
    public void testDecimalExponentiation() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 4.42954, calculator.evaluateMathExpression("2.4^1.7"), 0.00001);

    }

    @Test
    public void testSequantialExponentiation() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 6561d, calculator.evaluateMathExpression("3.0^2^4"), 0.00001);

    }
}
