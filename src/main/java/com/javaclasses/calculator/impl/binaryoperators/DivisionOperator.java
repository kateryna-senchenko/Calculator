package com.javaclasses.calculator.impl.binaryoperators;

import static com.javaclasses.calculator.impl.binaryoperators.Priority.MEDIUM;

/**
 * Implementation of the BinaryOperator interface for division operator
 */
public class DivisionOperator implements BinaryOperator{

    private final Priority priority = MEDIUM;

    @Override
    public double execute(double leftOperand, double rightOperand) {

        if (rightOperand == 0.0){
            throw new ArithmeticException("Division by 0 is not allowed");
        }

        return leftOperand / rightOperand;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BinaryOperator o) {

        if (this.priority.compareTo(o.getPriority()) < 0){
            return -1;
        } else if(this.priority.compareTo(o.getPriority()) == 0){
            return 0;
        }
        return 1;
    }
}
