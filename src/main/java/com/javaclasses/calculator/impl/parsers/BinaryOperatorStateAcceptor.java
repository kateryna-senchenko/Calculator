package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import com.javaclasses.calculator.impl.binaryoperators.BinaryOperator;
import com.javaclasses.calculator.impl.binaryoperators.BinaryOperatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

/**
 * Implementation of the StateAcceptor interface for Binary Operator StateAcceptor
 */
public class BinaryOperatorStateAcceptor implements StateAcceptor {

    private final Logger log = LoggerFactory.getLogger(BinaryOperatorStateAcceptor.class);

    @Override
    public boolean execute(InputContext input, Deque<EvaluationContext> outputContext) {

        if (input.hasMoreToParse()) {

            if (log.isDebugEnabled()) {
                log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
            }

            BinaryOperator operator =
                    new BinaryOperatorFactory().getBinaryOperator(input.getRemainingExpression().charAt(0));

            if (operator != null) {

                if (log.isInfoEnabled()) {
                    log.info("Parsed " + operator.getClass());
                }


                outputContext.peek().pushOperator(operator);
                input.incrementPointer();
                return true;

            }


        }
        return false;
    }
}
