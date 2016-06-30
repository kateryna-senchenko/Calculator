package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

/**
 * Implementation of the StateAcceptor interface for Closing Bracket StateAcceptor
 */
public class ClosingBracketStateAcceptor implements StateAcceptor {

    private final Logger log = LoggerFactory.getLogger(ClosingBracketStateAcceptor.class);

    public boolean execute(InputContext input, Deque<EvaluationContext> outputContext) {

        if(input.hasMoreToParse()) {

            if (log.isDebugEnabled()) {
                log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
            }

            if (input.getRemainingExpression().startsWith(")")) {

                if (log.isDebugEnabled()) {
                    log.debug("Parsed argument separator");
                }

                if (outputContext.size() < 2) {

                    log.error("Brackets do not match");
                    throw new IllegalStateException("Brackets do not match");
                }
                outputContext.peek().popAllOperators();
                double number = outputContext.pop().getResult();
                outputContext.peek().pushNumber(number);
                input.incrementPointer();

                return true;
            }

        }
        return false;
    }

}