package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AdditionTest {


    @Test
    public void testIntegerAddition() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 4d, calculator.evaluateMathExpression("2+2"), 0.0);

    }

    @Test
    public void testDecimalAddition() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 5.2468, calculator.evaluateMathExpression("3.1234+2.1234"), 0.0);
    }

    @Test
    public void testSequentialAddition() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 7.55, calculator.evaluateMathExpression("2.3+0.25+5"), 0.0);

    }
}
