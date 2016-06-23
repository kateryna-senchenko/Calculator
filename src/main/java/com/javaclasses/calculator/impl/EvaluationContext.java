package com.javaclasses.calculator.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;

public class EvaluationContext {

    private static final Logger log = LoggerFactory.getLogger(EvaluationContext.class);

    private Deque<Double> operandStack  = new ArrayDeque<>();

    public void pushNumber(double number){

        operandStack.push(number);

    }

    public double getResult(){

        return operandStack.pop();
    }


}


