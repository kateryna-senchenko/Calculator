package com.javaclasses.calculator.impl.binaryoperators;

import static com.javaclasses.calculator.impl.binaryoperators.Priority.MEDIUM;

/**
 * Implementation of the BinaryOperator interface for division operator
 */
public class DivisionOperator extends AbstractBinaryOperator{


    public DivisionOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {

        if (rightOperand == 0.0){
            throw new ArithmeticException("Division by 0 is not allowed");
        }

        return leftOperand / rightOperand;
    }


}
