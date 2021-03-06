package com.javaclasses.calculator.impl.parsers;


import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;

import java.util.Deque;

/**
 * Public API of the expression StateAcceptor
 */
public interface StateAcceptor {

    /**
     * Parses the expression and changes the outputContext according to the parsed lexeme
     * @param input - input context that contains expression remaining to execute
     * @param outputContext - evaluation context of the expression
     * @return true if lexeme was parsed and required operations on output context was performed, otherwise return false
     */
    boolean execute(InputContext input, Deque<EvaluationContext> outputContext);

}
