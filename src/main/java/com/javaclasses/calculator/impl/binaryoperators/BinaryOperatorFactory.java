package com.javaclasses.calculator.impl.binaryoperators;

/**
 * Factory to create instances of binary operators
 */
public class BinaryOperatorFactory {

    /**
     * Creates an instance of a binary operator
     * @param symbol - character of the required binary operator
     * @return instance of the required binary operator
     */
    public static BinaryOperator getBinaryOperator(char symbol){

        switch (symbol){

            case '+': return new Plus();

            case '-': return new Minus();

            case '*': return new MultiplicationOperator();

            case '/': return new DivisionOperator();

            case '^': return new Power();

            default: return null;
        }

    }
}
