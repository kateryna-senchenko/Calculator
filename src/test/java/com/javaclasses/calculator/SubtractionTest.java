package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubtractionTest {

    @Test
    public void testIntegerSubtraction() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", -4d, calculator.evaluateMathExpression("6-10"), 0.0);
    }

    @Test
    public void testDecimalSubtraction() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 33.546, calculator.evaluateMathExpression("53.67-20.124"), 0.0);
    }

    @Test
    public void testSequentialSubtraction() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 8.5, calculator.evaluateMathExpression("25-4-12.5"), 0.0);
    }
}
