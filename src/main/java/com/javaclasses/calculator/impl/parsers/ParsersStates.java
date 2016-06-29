package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.State;

import java.util.HashMap;
import java.util.Map;

import static com.javaclasses.calculator.impl.State.*;


/**
 * Contains map of available parsers according to the state
 */
public class ParsersStates {

    private final Map<State, Parser> availableParsers = new HashMap<State, Parser>(){{

        put(NUMBER, new NumberParser());
        put(BINARY_OPERATOR, new BinaryOperatorParser());


    }};


    public Map<State, Parser> getAvailableParsers(){
        return availableParsers;
    }
}

