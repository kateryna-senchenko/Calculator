package com.javaclasses.calculator.impl.binaryoperators;

import static com.javaclasses.calculator.impl.binaryoperators.Priority.LOW;

/**
 * Implementation of the BinaryOperator interface for addition operator
 */
public class Plus implements BinaryOperator{

    private final Priority priority = LOW;

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand + rightOperand;
    }

    public Priority getPriority(){
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
