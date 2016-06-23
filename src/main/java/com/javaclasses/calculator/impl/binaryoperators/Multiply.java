package com.javaclasses.calculator.impl.binaryoperators;


import static com.javaclasses.calculator.impl.binaryoperators.Priority.MEDIUM;

public class Multiply implements BinaryOperator {

    private final Priority priority = MEDIUM;

    @Override
    public double execute(double leftOperand, double rightOperand) {
        return leftOperand * rightOperand;
    }

    @Override
    public Priority getPriority() {
        return priority;
    }

    @Override
    public int compareTo(BinaryOperator o) {
        if (this.priority.compareTo(o.getPriority())<0){
            return -1;
        } else if(this.priority.compareTo(o.getPriority())==0)
            return 0;

        return 1;
    }
}
