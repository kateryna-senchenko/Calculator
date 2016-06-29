package com.javaclasses.calculator.impl.binaryoperators;

import static com.javaclasses.calculator.impl.binaryoperators.Priority.HIGH;

/**
 * Implementation of the BinaryOperator interface for exponentiation operator
 */
public class Power implements BinaryOperator {

    private final Priority priority = HIGH;

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return Math.pow(leftOperand, rightOperand);
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
