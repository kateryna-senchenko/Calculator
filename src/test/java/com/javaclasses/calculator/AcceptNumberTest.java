package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AcceptNumberTest {



    @Test
    public void testAcceptIntegerNumber() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("Integer number was not accepted", 4d, calculator.evaluateMathExpression("4"), 0.00001);

    }

    @Test
    public void testAcceptFloatingPointNumber() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("Floating point number was not accepted", 2.14, calculator.evaluateMathExpression("2.14"), 0.00001);

    }

    @Test
    public void testAcceptNegativeNumber() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("Negative number was not accepted", -3.2, calculator.evaluateMathExpression("-3.2"), 0.00001);

    }
}
