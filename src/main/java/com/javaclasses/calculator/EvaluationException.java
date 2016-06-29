package com.javaclasses.calculator;

/**
 * Custom exception to keep track of position where an error occurred
 */
public class EvaluationException extends Exception {

    private final int errorPosition;


    public EvaluationException(String message, int errorPointer){
        super(message + errorPointer);
        this.errorPosition = errorPointer;
    }

   public int getErrorPosition(){
       return errorPosition;
   }

}
