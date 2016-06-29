package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;
import com.javaclasses.calculator.impl.functions.ClosureContext;
import com.javaclasses.calculator.impl.functions.Function;
import com.javaclasses.calculator.impl.functions.FunctionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;

/**
 * Implementation of the Parser interface for Function Parser
 */
public class FunctionParser implements Parser {

    private final Logger log = LoggerFactory.getLogger(FunctionParser.class);


    @Override
    public boolean parse(InputContext input, Deque<EvaluationContext> outputContext) {


        if (!Character.isLetter(input.getRemainingExpression().charAt(0))){
            return false;
        } else {

            StringBuilder functionName = new StringBuilder();

            while(input.hasMoreToParse() && Character.isLetter(input.getRemainingExpression().charAt(0))){

                if (log.isDebugEnabled()){
                    log.debug("Start parsing symbol " + input.getRemainingExpression().charAt(0));
                }

                functionName.append(input.getRemainingExpression().charAt(0));
                input.incrementPointer();

            }

            if(!input.hasMoreToParse() || !input.getRemainingExpression().startsWith("(")){

                log.error("Expression" + functionName + " is illegal");
                throw new IllegalStateException("Expression " + functionName + " is illegal");

            } else {
                functionName.append("(");
                input.incrementPointer();
            }

            if (log.isDebugEnabled()){
                log.debug("Parsed function " + functionName);
            }

            Function function =
                    new FunctionFactory().getFunction(functionName.toString());
            outputContext.push(new EvaluationContext(outputContext.peek(), new ClosureContext(function)));

        }


        return true;
    }

}
