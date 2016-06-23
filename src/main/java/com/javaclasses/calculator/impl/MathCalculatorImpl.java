package com.javaclasses.calculator.impl;


import com.javaclasses.calculator.MathCalculator;
import com.javaclasses.calculator.EvaluationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.javaclasses.calculator.impl.State.*;

public class MathCalculatorImpl implements MathCalculator  {

    private static final Logger log = LoggerFactory.getLogger(EvaluationContext.class);

    private int pointer = 0;
    private State currentState = START;
    private EvaluationContext evaluationContext = new EvaluationContext();


    @Override
    public double evaluateMathExpression(String expression) throws EvaluationException {

        expression = expression.replaceAll("\\s", "");

        if (expression.isEmpty()){
            throw new EvaluationException("Input should contain mathematical expression",0);
        }

        return evaluationContext.getResult();
    }


}
