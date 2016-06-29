package com.javaclasses.calculator.impl.functions;

/**
 * Implementation of the Function interface for min()
 */
public class MinimumFunction implements Function{

    @Override
    public double execute(Double... arguments) {

        if (arguments.length < 1){
            throw new IllegalStateException("Minimum function should contain arguments");
        }

        double min = arguments[0];

        for(double argument: arguments){
            if(argument < min){
                min = argument;
            }
        }

        return min;
    }
}
