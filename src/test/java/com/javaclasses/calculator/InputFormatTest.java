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
}
