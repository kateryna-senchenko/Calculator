package com.javaclasses.calculator.impl.binaryoperators;


/**
 * Implementation of the BinaryOperator interface for multiplication operator
 */
public class MultiplicationOperator extends AbstractBinaryOperator {


    public MultiplicationOperator(Priority priority) {
        super(priority);
    }

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }



}
