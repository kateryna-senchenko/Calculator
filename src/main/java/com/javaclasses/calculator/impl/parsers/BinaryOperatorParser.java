package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import com.javaclasses.calculator.impl.binaryoperators.BinaryOperator;
import com.javaclasses.calculator.impl.binaryoperators.BinaryOperatorFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

/**
 * Implementation of the Parser interface for Binary Operator Parser
 */
public class BinaryOperatorParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(BinaryOperatorParser.class);

    @Override
    public boolean parse(InputContext input, Deque<EvaluationContext> outputContext) {

        if (log.isDebugEnabled()){
            log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
        }

        BinaryOperator operator =
                new BinaryOperatorFactory().getBinaryOperator(input.getRemainingExpression().charAt(0));

        if(operator != null){

            if(log.isInfoEnabled()){
                log.info("Parsed " + operator.getClass());
            }

            // change outputContext according to the parsed operation
            outputContext.peek().pushOperator(operator);
            input.incrementPointer();

        } else return false;

        return true;
    }


}
