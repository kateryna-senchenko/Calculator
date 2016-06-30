package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

/**
 * Implementation of the StateAcceptor interface for Opening Bracket StateAcceptor
 */
public class OpeningBracketStateAcceptor implements StateAcceptor {


    private final Logger log = LoggerFactory.getLogger(OpeningBracketStateAcceptor.class);


    public boolean execute(InputContext input, Deque<EvaluationContext> outputContext){

        if(input.hasMoreToParse()) {


            if (log.isDebugEnabled()) {
                log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
            }

            if (input.getRemainingExpression().startsWith("(")) {

                if (log.isDebugEnabled()) {
                    log.debug("Parsed opening bracket");
                }

                outputContext.push(new EvaluationContext(outputContext.peek(), null));
                input.incrementPointer();

                return true;

            }


        }
        return false;
    }
}
