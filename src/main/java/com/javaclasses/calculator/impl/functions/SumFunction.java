package com.javaclasses.calculator.impl.functions;

/**
 * Implementation of the Function interface for sum() function
 */
public class SumFunction implements Function{


    @Override
    public double execute(Double... arguments) {

        double sum = 0;

        for(double argument: arguments){
            sum += argument;
        }

        return sum;
    }
}
