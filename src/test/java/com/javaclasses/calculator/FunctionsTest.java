package com.javaclasses.calculator;

import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class FunctionsTest {

    @Test
    public void testSum() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 10d, calculator.evaluateMathExpression("sum(6+2,4/2)"), 0.00001);

    }

    @Test
    public void testMaximum() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 6d, calculator.evaluateMathExpression("max(3,6,2,4)"), 0.00001);
    }

    @Test
    public void testFunctionAsArgument() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 10d, calculator.evaluateMathExpression("sum(max(3,6,2,4),4)"), 0.00001);

    }

    @Test
    public void testMinimum() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 2d, calculator.evaluateMathExpression("min(3,6,2,4)"), 0.00001);

    }

    @Test
    public void testMaximumWithNoArguments() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        try {
            calculator.evaluateMathExpression("max()");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Maximum function should contain arguments", e.getMessage());
        }
    }

    @Test
    public void testPiFunction() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 3.14159, calculator.evaluateMathExpression("pi()"), 0.00001);

    }

    @Test
    public void testPiFunctionAsArgument() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 7.14159, calculator.evaluateMathExpression("4+min(pi(),4)"), 0.00001);

    }

    @Test
    public void testPiFunctionWithParameters(){

        final MathCalculator calculator = new MathCalculatorImpl();

        try {
            calculator.evaluateMathExpression("pi(2)");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("pi() function should not contain arguments", e.getMessage());
        }

    }

    @Test
    public void testMixedExpression() throws EvaluationException {

        final MathCalculator calculator = new MathCalculatorImpl();

        assertEquals("The result is incorrect", 16d, calculator.evaluateMathExpression("5*3-2^2*min(2,1)+5"), 0.00001);
    }
}
