package com.javaclasses.calculator.impl;


import com.javaclasses.calculator.MathCalculator;
import com.javaclasses.calculator.EvaluationException;
import com.javaclasses.calculator.impl.parsers.FinishParser;
import com.javaclasses.calculator.impl.parsers.NumberParser;
import com.javaclasses.calculator.impl.parsers.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static com.javaclasses.calculator.impl.State.*;


public class MathCalculatorImpl implements MathCalculator {

    private static final Logger log = LoggerFactory.getLogger(EvaluationContext.class);

    private int pointer = 0;
    private State currentState = START;
    private Map<State, Parser[]> transitionMatrix;
    private EvaluationContext evaluationContext = new EvaluationContext();


    public MathCalculatorImpl() {

        transitionMatrix = new HashMap<>();

        transitionMatrix.put(START, new Parser[]{new NumberParser()});
        transitionMatrix.put(NUMBER, new Parser[]{new FinishParser()});

    }


    @Override
    public double evaluateMathExpression(String expression) throws EvaluationException {

        expression = expression.replaceAll("\\s", "");

        if (expression.isEmpty()) {
            throw new EvaluationException("Input should contain mathematical expression", 0);

        }

        while (currentState != FINISH) {

            Parser[] possibleParsers = transitionMatrix.get(currentState);

            for (Parser parser : possibleParsers) {

                if (parser.parse(expression, pointer).getClass().equals(Double.class)) {

                    double number = (double) parser.parse(expression, pointer);
                    evaluationContext.pushNumber(number);
                    pointer = parser.getParsePosition();
                    currentState = NUMBER;
                    break;

                }

            }
            if (pointer == (expression.length())){
                currentState = FINISH;
            }
        }

        return evaluationContext.getResult();
    }
}
