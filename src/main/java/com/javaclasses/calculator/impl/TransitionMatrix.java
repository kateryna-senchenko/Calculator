package com.javaclasses.calculator.impl;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.javaclasses.calculator.impl.State.*;

/**
 * Contains possible transitions from each state of the MathCalculator
 */
public class TransitionMatrix {

    private final Map<State, Set<State>> availableTransitions = new HashMap<State, Set<State>>(){{

        put(START, EnumSet.of(NUMBER, FUNCTION, OPENING_BRACKET));
        put(NUMBER, EnumSet.of(BINARY_OPERATOR,CLOSING_BRACKET,ARGUMENT_SEPARATOR, FINISH));
        put(BINARY_OPERATOR, EnumSet.of(NUMBER,OPENING_BRACKET, FUNCTION));
        put(OPENING_BRACKET, EnumSet.of(NUMBER, FUNCTION));
        put(CLOSING_BRACKET, EnumSet.of(BINARY_OPERATOR, ARGUMENT_SEPARATOR, FINISH));
        put(FUNCTION, EnumSet.of(NUMBER, FUNCTION,CLOSING_BRACKET));
        put(ARGUMENT_SEPARATOR, EnumSet.of(NUMBER, FUNCTION, OPENING_BRACKET));

    }};


    public Map<State, Set<State>> getTransitionMatrix(){
        return availableTransitions;
    }

    public Set<State> getPossibleTransitions(State state){
        return availableTransitions.get(state);
    }
}
