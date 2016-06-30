package com.javaclasses.calculator.impl.binaryoperators;

/**
 *  Abstract Binary Operator class
 */
abstract class AbstractBinaryOperator implements BinaryOperator{

    private Priority priority;

    public AbstractBinaryOperator(Priority priority){
        this.priority = priority;
    }

    @Override
    public int compareTo(BinaryOperator o) {

        if (this.priority.compareTo(o.getPriority()) < 0){
            return -1;
        } else if(this.priority.compareTo(o.getPriority()) == 0){
            return 0;
        }
        return 1;
    }

    @Override
    public Priority getPriority(){
        return priority;
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }
}
