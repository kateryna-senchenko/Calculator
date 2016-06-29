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
        put(OPENING_BRACKET, new OpeningBracketParser());
        put(CLOSING_BRACKET, new ClosingBracketParser());
        put(FUNCTION, new FunctionParser());
        put(ARGUMENT_SEPARATOR, new ArgumentSeparatorParser());

    }};


    public Map<State, Parser> getAvailableParsers(){
        return availableParsers;
    }
}

