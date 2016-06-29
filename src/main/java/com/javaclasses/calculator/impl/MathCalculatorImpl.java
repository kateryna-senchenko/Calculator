package com.javaclasses.calculator.impl;


import com.javaclasses.calculator.MathCalculator;
import com.javaclasses.calculator.EvaluationException;
import com.javaclasses.calculator.impl.parsers.Parser;
import com.javaclasses.calculator.impl.parsers.ParsersStates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static com.javaclasses.calculator.impl.State.*;

/**
 * Implementation of the MathCalculator interface, contains evaluation stack to calculate result
 */
public class MathCalculatorImpl implements MathCalculator {

    private static final Logger log = LoggerFactory.getLogger(MathCalculatorImpl.class);

    private State currentState = START;
    private Map<State, Set<State>> transitionMatrix;
    private Map<State, Parser> availableParsers;

    private Deque<EvaluationContext> evaluationStack = new ArrayDeque<>();
    private InputContext input;


    public MathCalculatorImpl() {

        transitionMatrix = new TransitionMatrix().getTransitionMatrix();
        availableParsers = new ParsersStates().getAvailableParsers();
        evaluationStack.push(new EvaluationContext());

    }


    @Override
    public double evaluateMathExpression(String expression) throws EvaluationException {

        expression = expression.replaceAll("\\s", "");

        if (expression.isEmpty()) {
            log.error("Empty input");
            throw new EvaluationException("Input should contain mathematical expression ", 0);
        }

        input = new InputContext(expression);


        while (currentState != FINISH) {

            if (log.isInfoEnabled()) {
                log.info("Moving from state " + currentState);
            }

            moveForward(transitionMatrix.get(currentState));

            if (log.isInfoEnabled()) {
                log.info("Moved to the state " + currentState);
            }

            if (!input.hasMoreToParse()) {
                currentState = FINISH;

                if (log.isInfoEnabled()) {
                    log.info("Moved to the state " + currentState);
                }
            }
        }

        if(evaluationStack.size() > 1)  {

            log.error("Evaluation failed, brackets do not match");
            throw new EvaluationException("Should contain closing bracket at index ", input.getPointer());

        }


        return evaluationStack.pop().getResult();

    }

    /**
     * Gets the right parser and moves to the next state
     * @param possibleMoves - possible transitions from the current state
     * @throws EvaluationException to point where the error occurred
     */
    private void moveForward(Set<State> possibleMoves) throws EvaluationException {

        boolean hasMoved = false;

        for (State state : possibleMoves) {

            if(availableParsers.get(state).parse(input, evaluationStack)){
                hasMoved=true;
                currentState = state;

                if (log.isDebugEnabled()) {
                    log.debug("State " + currentState + " is accepted");
                }
                break;
            }

        }
        if (!hasMoved){

            log.error("No state was accepted, invalid input character " + input.getRemainingExpression().charAt(0));
            throw new EvaluationException("Illegal symbol at index ", input.getPointer());
        }

    }
}
