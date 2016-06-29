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

    private final Map<State, Set<State>> possibleTransitions = new HashMap<State, Set<State>>(){{

        put(START, EnumSet.of(NUMBER, OPENING_BRACKET));
        put(NUMBER, EnumSet.of(BINARY_OPERATOR));
        put(BINARY_OPERATOR, EnumSet.of(NUMBER, OPENING_BRACKET));
        put(OPENING_BRACKET, EnumSet.of(NUMBER));

    }};


    public Map<State, Set<State>> getTransitionMatrix(){
        return possibleTransitions;
    }
}
