package com.javaclasses.calculator.impl.functions;

/**
 * Public API of Function
 */
public interface Function {

    /**
     * Executes function
     * @param arguments - function arguments
     * @return calculated value
     */
    double execute(Double... arguments);

}
