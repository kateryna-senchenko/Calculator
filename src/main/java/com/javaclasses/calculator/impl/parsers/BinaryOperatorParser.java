package com.javaclasses.calculator.impl.parsers;


import com.javaclasses.calculator.impl.State;
import com.javaclasses.calculator.impl.binaryoperators.BinaryOperator;
import com.javaclasses.calculator.impl.binaryoperators.BinaryOperatorFactory;

public class BinaryOperatorParser implements Parser {

    private final State state = State.BINARY_OPERATOR;
    private int parsePosition;

    @Override
    public BinaryOperator parse(String expression, int pointer) {

        BinaryOperator operator =
                new BinaryOperatorFactory().getBinaryOperator(expression.substring(pointer, ++pointer));

        parsePosition = pointer;

        return operator;
    }

    @Override
    public int getParsePosition() {
        return parsePosition;
    }

    @Override
    public State getState(){
        return state;
    }



}
