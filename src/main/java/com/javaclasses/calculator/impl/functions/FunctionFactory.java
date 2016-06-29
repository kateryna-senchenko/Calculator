package com.javaclasses.calculator.impl.functions;

/**
 * Factory to create instances of functions
 */
public class FunctionFactory {

    /**
     * Creates an instance of a function
     * @param functionName - name of the required function
     * @return instance of the required function
     */
    public static Function getFunction(String functionName){

        switch (functionName){

            case "sum(": return new SumFunction();

            default: throw new IllegalStateException("Expression " + functionName + " is illegal");
        }

    }
}

