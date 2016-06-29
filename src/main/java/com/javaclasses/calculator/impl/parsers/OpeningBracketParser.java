package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;

import java.util.Deque;

/**
 *
 */
public class OpeningBracketParser implements Parser{



    public boolean parse(InputContext input, Deque<EvaluationContext> outputContext){


        if(input.getRemainingExpression().startsWith("(")){

            outputContext.push(new EvaluationContext(outputContext.peek(), null));
            input.incrementPointer();

        } else return false;



        return true;
    }
}
