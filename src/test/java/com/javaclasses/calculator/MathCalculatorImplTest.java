package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathCalculatorImplTest {

    @Test
    public void testSequentialAdditionAndSubtraction() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 48.85, calculator.evaluateMathExpression("41-4.6+12.45"), 0.0);
    }
}
