package com.javaclasses.calculator.impl.binaryoperators;


public interface BinaryOperator{


    double execute(double leftOperand, double rightOperand);

    Priority getPriority();

    int compareTo(BinaryOperator o);
}
