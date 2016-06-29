package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BracketsTest {

    @Test
    public void testSingleBrackets() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 18d, calculator.evaluateMathExpression("(4+2)*3"), 0.00001);

    }

    @Test
    public void testNestedBrackets() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 0.9, calculator.evaluateMathExpression("(8.5-(4+2/10-2)*3)-1"), 0.00001);

    }
}
