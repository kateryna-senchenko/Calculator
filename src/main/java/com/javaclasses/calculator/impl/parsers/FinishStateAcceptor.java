package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.EvaluationContext;
import com.javaclasses.calculator.impl.InputContext;

import java.util.Deque;

/**
 * Implementation of the StateAcceptor interface for Finish StateAcceptor
 */
public class FinishStateAcceptor implements StateAcceptor {


    @Override
    public boolean execute(InputContext input, Deque<EvaluationContext> outputContext) {

        if (!input.hasMoreToParse()) {
            return true;
        }
        return false;
    }
}
