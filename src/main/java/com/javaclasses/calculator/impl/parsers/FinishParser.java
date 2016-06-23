package com.javaclasses.calculator.impl.parsers;


import com.javaclasses.calculator.impl.State;

public class FinishParser implements Parser {

    private final State state = State.FINISH;

    @Override
    public Object parse(String expression, int pointer) {
        return null;
    }

    @Override
    public int getParsePosition() {
        return 0;
    }

    @Override
    public State getState() {
        return state;
    }


}
