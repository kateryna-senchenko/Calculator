package com.javaclasses.calculator.impl.functions;

/**
 * Implementation of the Function interface for pi() function
 */
public class PiFunction implements Function{


    @Override
    public double execute(Double... arguments) {

        if (arguments.length > 0){
            throw new IllegalStateException("pi() function should not contain arguments");
        }
        return Math.PI;
    }
}
