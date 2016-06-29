package com.javaclasses.calculator.impl.functions;

/**
 * Implementation of the Function interface for max()
 */
public class MaximumFunction implements Function {



    @Override
    public double execute(Double... arguments) {

        if (arguments.length < 1){
            throw new IllegalStateException("Maximum function should contain arguments");
        }

        double max = arguments[0];

        for(double argument: arguments){
            if(argument > max){
                max = argument;
            }
        }

        return max;
    }
}
