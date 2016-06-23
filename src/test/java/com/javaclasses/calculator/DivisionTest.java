package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivisionTest {

    @Test
    public void testIntegerDivision() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 3d, calculator.evaluateMathExpression("18/6"), 0.00001);

    }

    @Test
    public void testDecimalDivision() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 9.47541, calculator.evaluateMathExpression("57.8/6.1"), 0.00001);

    }

    @Test
    public void testSequentialDivision() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 2.75, calculator.evaluateMathExpression("22/2/4.0"), 0.00001);

    }
}
