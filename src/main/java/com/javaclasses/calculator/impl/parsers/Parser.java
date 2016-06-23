package com.javaclasses.calculator.impl.parsers;


public interface Parser {

    Object parse(String expression, int pointer);

    int getParsePosition();

}
