package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MultiplicationTest {

    @Test
    public void testIntegerMultiplication() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 16d, calculator.evaluateMathExpression("2*8"), 0.00001);

    }

    @Test
    public void testDecimalMultiplication() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 22.41, calculator.evaluateMathExpression("2.7*8.3"), 0.00001);

    }

    @Test
    public void testSequentialMultiplication() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 97.455, calculator.evaluateMathExpression("3.65*8.9*3"), 0.00001);

    }

}
