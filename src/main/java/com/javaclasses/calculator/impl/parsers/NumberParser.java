package com.javaclasses.calculator.impl.parsers;


import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.Deque;

/**
 * Implementation of the Parser interface for Number Parser
 */
public class NumberParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(BinaryOperatorParser.class);

    @Override
    public boolean parse(InputContext input, Deque<EvaluationContext> outputContext){

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        ParsePosition parsePosition = new ParsePosition(0);
        double number;

        try{

            if (log.isDebugEnabled()){
                log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
            }

            number = decimalFormat.parse(input.getRemainingExpression(), parsePosition).doubleValue();

            if(log.isInfoEnabled()){
                log.info("Parsed " + number);
            }

            input.updatePointer(parsePosition.getIndex());

            // change outputContext according to the parsed expression
            outputContext.peek().pushNumber(number);

        }catch(Exception e){
            return false;
        }

        return true;
    }


}