package com.javaclasses.calculator.impl.binaryoperators;

import static com.javaclasses.calculator.impl.binaryoperators.Priority.LOW;

/**
 * Implementation of the BinaryOperator interface for addition operator
 */
public class Plus extends AbstractBinaryOperator{


    public Plus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }




}
