package com.javaclasses.calculator.impl;

/**
 * Enum of available states for MathCalculator
 */
public enum State {

    START,
    NUMBER,
    BINARY_OPERATOR,
    OPENING_BRACKET,
    CLOSING_BRACKET,
    FUNCTION,
    ARGUMENT_SEPARATOR,
    FINISH

}
