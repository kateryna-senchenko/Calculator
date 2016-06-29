package com.javaclasses.calculator;

/**
 * Public API of the Mathematical Calculator
 */
public interface MathCalculator {

    /**
     * Evaluates mathematical expression
     * @param expression - mathematical expression in String
     * @return calculated value
     * @throws EvaluationException to point where the error occurred
     */
    double evaluateMathExpression(String expression) throws EvaluationException;

}
