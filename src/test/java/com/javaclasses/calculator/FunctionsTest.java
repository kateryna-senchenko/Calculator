package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class FunctionsTest {

    @Test
    public void testSingleSum() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 10d, calculator.evaluateMathExpression("sum(6+2,4/2)"), 0.00001);

    }
}
