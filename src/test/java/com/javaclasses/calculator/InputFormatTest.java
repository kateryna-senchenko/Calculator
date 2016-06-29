package com.javaclasses.calculator;


import com.javaclasses.calculator.impl.MathCalculatorImpl;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class InputFormatTest {

    private MathCalculator calculator = new MathCalculatorImpl();

    @Test
    public void testEmptyInput(){

        try {
            calculator.evaluateMathExpression("");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Input should contain mathematical expression", e.getMessage());
        }

        try {
            calculator.evaluateMathExpression(" ");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Input should contain mathematical expression", e.getMessage());
        }
    }


    @Test
    public void testInvalidBinaryOperator(){

        try {
            calculator.evaluateMathExpression("5&3");
            fail("Expected exception was not thrown");
        } catch (EvaluationException e) {
            assertEquals("Illegal symbol &", e.getMessage());
        }

    }

    @Test
    public void testBrackets(){

        try {
            calculator.evaluateMathExpression("2+(3-2");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Should contain closing bracket", e.getMessage());
        }

    }

    @Test
    public void testMismatchedBracket(){

        try {
            calculator.evaluateMathExpression("(2+3)*5)");
            fail("Expected exception was not thrown");
        } catch (Exception e) {
            assertEquals("Brackets do not match", e.getMessage());
        }

    }
}
