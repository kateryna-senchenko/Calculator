package com.javaclasses.calculator.impl;

/**
 * Contains evaluation expression and pointer to the char to be parsed next
 */
public class InputContext {

    private String evaluationExpression;
    private int pointer;

    public InputContext(String evaluationExpression){

        this.evaluationExpression = evaluationExpression;
        pointer = 0;
    }


    public void incrementPointer(){
        pointer++;
    }

    public void updatePointer(int value){
        pointer += value;
    }

    public int getPointer(){
        return pointer;
    }

    public String getRemainingExpression(){
        return evaluationExpression.substring(pointer);
    }

    /**
     * Checks if the expression has more characters to be parsed
     * @return true if expression has more to parse, otherwise return false
     */
    public boolean hasMoreToParse(){

        if(pointer >= evaluationExpression.length()){
            return false;
        }
        return true;
    }
}
