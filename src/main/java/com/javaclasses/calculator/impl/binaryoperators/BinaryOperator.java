package com.javaclasses.calculator.impl.binaryoperators;

/**
 * Public API of Binary Operator
 */
public interface BinaryOperator{

    /**
     * Executes binary operator
     * @param leftOperand - left operand of the expression
     * @param rightOperand - right operand of the expression
     * @return calculated value
     */
    double execute(double leftOperand, double rightOperand);


    Priority getPriority();

    int compareTo(BinaryOperator o);
}
