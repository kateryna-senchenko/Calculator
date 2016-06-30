package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

/**
 * Implementation of the StateAcceptor interface for Argument Separator StateAcceptor
 */
public class ArgumentSeparatorStateAcceptor implements StateAcceptor {


    private final Logger log = LoggerFactory.getLogger(ArgumentSeparatorStateAcceptor.class);

    @Override
    public boolean execute(InputContext input, Deque<EvaluationContext> outputContext) {

        if (input.hasMoreToParse()) {

            if (log.isDebugEnabled()) {
                log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
            }

            if (input.getRemainingExpression().startsWith(",")) {

                outputContext.peek().popAllOperators();

                if (log.isDebugEnabled()) {
                    log.debug("Parsed argument separator");
                }

                input.incrementPointer();
                return true;
            }

        }

        return false;
    }
}
