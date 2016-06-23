package com.javaclasses.calculator.impl.binaryoperators;


import java.math.BigDecimal;

public class Minus implements BinaryOperator{

    private final Priority priority = Priority.LOW;

    @Override
    public double execute(double leftOperand, double rightOperand) {

        return leftOperand - rightOperand;
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
