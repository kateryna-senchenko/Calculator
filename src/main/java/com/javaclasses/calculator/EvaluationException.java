package com.javaclasses.calculator;

/**
 * Custom exception to keep track of position where an error occurred
 */
public class EvaluationException extends Exception {

    private final int errorPointer;


    public EvaluationException(String message, int errorPointer){
        super(message);
        this.errorPointer = errorPointer;
    }

    public String getMassage(){
        return (super.getMessage() + errorPointer);
    }

}
