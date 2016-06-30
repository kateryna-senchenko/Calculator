package com.javaclasses.calculator.impl.binaryoperators;

import static com.javaclasses.calculator.impl.binaryoperators.Priority.HIGH;

/**
 * Implementation of the BinaryOperator interface for exponentiation operator
 */
public class Power extends AbstractBinaryOperator {


    public Power(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
    }



   }
