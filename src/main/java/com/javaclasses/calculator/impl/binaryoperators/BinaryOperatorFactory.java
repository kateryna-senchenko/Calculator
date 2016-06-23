package com.javaclasses.calculator.impl.binaryoperators;


public class BinaryOperatorFactory {

    public static BinaryOperator getBinaryOperator(String symbol){

        switch (symbol){

            case "+": return new Plus();

            case "-": return new Minus();

            case "*": return new MultiplicationOperator();

            case "/": return new DivisionOperator();

            default: return null;
        }

    }
}
