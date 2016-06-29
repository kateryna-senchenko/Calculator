package com.javaclasses.calculator.impl.functions;

/**
 * Class to define a function for evaluating the context
 */
public class ClosureContext {

    private final Function function;

    public ClosureContext(Function function){
        this.function = function;
    }


    public Function getFunction(){
        return function;
    }
}
