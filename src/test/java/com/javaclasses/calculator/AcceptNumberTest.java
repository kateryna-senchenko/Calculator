package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
public class AcceptNumberTest {



    @Test
    public void testAcceptIntegerNumber() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 4d, calculator.evaluateMathExpression("4"), 0.0);

    }

    @Test
    public void testAcceptDecimalNumber() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 2.14, calculator.evaluateMathExpression("2.14"), 0.0);

    }

    @Test
    public void testAcceptNegativeNumber() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", -3.2, calculator.evaluateMathExpression("-3.2"), 0.0);

    }
}
