package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

/**
 * Implementation of the Parser interface for Argument Separator Parser
 */
public class ArgumentSeparatorParser implements Parser{


    private final Logger log = LoggerFactory.getLogger(ArgumentSeparatorParser.class);

    @Override
    public boolean parse(InputContext input, Deque<EvaluationContext> outputContext) {

        if (log.isDebugEnabled()){
            log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
        }

        if(input.getRemainingExpression().startsWith(",")){

            outputContext.peek().popAllOperators();

            if(log.isDebugEnabled()){
                log.debug("Parsed argument separator");
            }

            input.incrementPointer();

        } else return false;



        return true;
    }


}
