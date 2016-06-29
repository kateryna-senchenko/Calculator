package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;

import java.util.Deque;

/**
 *
 */
public class ClosingBracketParser implements Parser {


    public boolean parse(InputContext input, Deque<EvaluationContext> outputContext) {

        if (input.getRemainingExpression().startsWith(")")) {

            if (outputContext.size() < 2) {
                throw new IllegalStateException("Brackets do not match");
            }
            double number = outputContext.pop().getResult();
            outputContext.peek().pushNumber(number);
            input.incrementPointer();

        } else return false;


        return true;
    }

}