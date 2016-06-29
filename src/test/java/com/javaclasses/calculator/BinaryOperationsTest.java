package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BinaryOperationsTest {

    @Test
    public void testAddition() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 7.55, calculator.evaluateMathExpression("2.3+0.25+5"), 0.00001);

    }


    @Test
    public void testSubtraction() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 8.5, calculator.evaluateMathExpression("25-4-12.5"), 0.00001);
    }


    @Test
    public void testMultiplication() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 97.455, calculator.evaluateMathExpression("3.65*8.9*3"), 0.00001);

    }


    @Test
    public void testDivision() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 9.47541, calculator.evaluateMathExpression("57.8/6.1"), 0.00001);

    }

    @Test
    public void testDivisionByZero(){
        final MathCalculator calculator = new MathCalculatorImpl();

        try {
            calculator.evaluateMathExpression("24/0");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Division by 0 is not allowed", e.getMessage());
        }

    }

    @Test
    public void testExponentiation() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 4.42954, calculator.evaluateMathExpression("2.4^1.7"), 0.00001);

    }

    @Test
    public void testAllBinaryOperations() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 6.75, calculator.evaluateMathExpression("5*3-2^2*3+5/8*6"), 0.00001);
    }
}
