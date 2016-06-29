package com.javaclasses.calculator.impl.functions;

/**
 * Implementation of the Function interface for max()
 */
public class MaximumFunction implements Function {



    @Override
    public double execute(Double... arguments) {

        double max = arguments[0];

        for(double argument: arguments){
            if(argument > max){
                max = argument;
            }
        }

        return max;
    }
}
