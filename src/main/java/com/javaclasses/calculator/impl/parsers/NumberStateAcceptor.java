package com.javaclasses.calculator.impl.parsers;


import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.Deque;

/**
 * Implementation of the StateAcceptor interface for Number StateAcceptor
 */
public class NumberStateAcceptor implements StateAcceptor {

    private final Logger log = LoggerFactory.getLogger(NumberStateAcceptor.class);

    @Override
    public boolean execute(InputContext input, Deque<EvaluationContext> outputContext){

        if(input.hasMoreToParse()) {

            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            ParsePosition parsePosition = new ParsePosition(0);
            double number;

            try {

                if (log.isDebugEnabled()) {
                    log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
                }

                number = decimalFormat.parse(input.getRemainingExpression(), parsePosition).doubleValue();

                if (log.isInfoEnabled()) {
                    log.info("Parsed " + number);
                }

                input.updatePointer(parsePosition.getIndex());
                outputContext.peek().pushNumber(number);

                return true;

            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }


}