package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FunctionsTest {

    @Test
    public void testSum() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 10d, calculator.evaluateMathExpression("sum(6+2,4/2)"), 0.00001);

    }

    @Test
    public void testMaximum() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 6d, calculator.evaluateMathExpression("max(3,6,2,4)"), 0.00001);
    }

    @Test
    public void testFunctionAsArgument() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 10d, calculator.evaluateMathExpression("sum(max(3,6,2,4),4)"), 0.00001);

    }
}
