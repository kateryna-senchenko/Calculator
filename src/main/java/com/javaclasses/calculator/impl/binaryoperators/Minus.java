package com.javaclasses.calculator.impl.binaryoperators;

import static com.javaclasses.calculator.impl.binaryoperators.Priority.LOW;

/**
 * Implementation of the BinaryOperator interface for subtraction operator
 */
public class Minus extends AbstractBinaryOperator{


    public Minus(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand - rightOperand;
    }



}
