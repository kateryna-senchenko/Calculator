package com.javaclasses.calculator;


public class EvaluationException extends Exception {

    private final int errorPointer;



    public EvaluationException(String message, int errorPointer){
        super(message);
        this.errorPointer = errorPointer;
    }

    public int getErrorPointer(){
        return errorPointer;
    }

}
