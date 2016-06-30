package com.javaclasses.calculator.impl.parsers;

import com.javaclasses.calculator.impl.State;

import java.util.HashMap;
import java.util.Map;

import static com.javaclasses.calculator.impl.State.*;


/**
 * Contains map of available parsers according to the state
 */
public class ParsersStates {

    private final Map<State, StateAcceptor> availableParsers = new HashMap<State, StateAcceptor>(){{

        put(NUMBER, new NumberStateAcceptor());
        put(BINARY_OPERATOR, new BinaryOperatorStateAcceptor());
        put(OPENING_BRACKET, new OpeningBracketStateAcceptor());
        put(CLOSING_BRACKET, new ClosingBracketStateAcceptor());
        put(FUNCTION, new FunctionStateAcceptor());
        put(ARGUMENT_SEPARATOR, new ArgumentSeparatorStateAcceptor());
        put(FINISH, new FinishStateAcceptor());

    }};


    public Map<State, StateAcceptor> getAvailableParsers(){
        return availableParsers;
    }
}

