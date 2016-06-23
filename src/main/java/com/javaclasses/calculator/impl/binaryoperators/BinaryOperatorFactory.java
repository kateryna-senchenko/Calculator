package com.javaclasses.calculator.impl.binaryoperators;


public class BinaryOperatorFactory {

    public static BinaryOperator getBinaryOperator(String symbol){

        switch (symbol){

            case "+": return new Plus();

            default: return null;
        }

    }
}
