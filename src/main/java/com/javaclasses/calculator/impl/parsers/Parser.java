package com.javaclasses.calculator.impl.parsers;


import com.javaclasses.calculator.impl.State;

public interface Parser {

    Object parse(String expression, int pointer);


    int getParsePosition();

    State getState();
}
