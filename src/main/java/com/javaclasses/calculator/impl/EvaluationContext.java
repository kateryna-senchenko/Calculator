package com.javaclasses.calculator.impl;


import com.javaclasses.calculator.impl.binaryoperators.BinaryOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationContext {

    private static final Logger log = LoggerFactory.getLogger(EvaluationContext.class);

    private Deque<Double> operandStack  = new ArrayDeque<>();
    private Deque<BinaryOperator> operatorStack = new ArrayDeque<>();

    public void pushNumber(double number){

        operandStack.push(number);

    }

    public void pushOperator(BinaryOperator operator) {

        while (operatorStack.size() > 0 && operator.compareTo(operatorStack.peek()) < 0) {

            BinaryOperator currentOperation = operatorStack.pop();
            double rightOperand = operandStack.pop();
            double leftOperand = operandStack.pop();

            operandStack.push(currentOperation.execute(leftOperand, rightOperand));
        }

        operatorStack.push(operator);
    }

    public double getResult(){

        while(operatorStack.size()>0) {

            BinaryOperator currentOperation = operatorStack.pop();
            double rightOperand = operandStack.pop();
            double leftOperand = operandStack.pop();

            operandStack.push(currentOperation.execute(leftOperand, rightOperand));

        }

        return operandStack.pop();
    }


}


